package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.Out.User_PatientRepositoryOutPort;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers.UserPatientMapper;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Repositories.SpringDataUserRepository;
import com.sacm.Backend.Common.Exception.EmptyResultDataAccessException;
import com.sacm.Backend.Common.Exception.InternalServerException;
import com.sacm.Backend.Common.Exception.MethodArgumentNotValidException;
import com.sacm.Backend.Common.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida {@link User_PatientRepositoryOutPort}
 * para interactuar con la base de datos mediante el repositorio Spring Data {@link SpringDataUserRepository}.
 *
 * Este componente traduce objetos del modelo de dominio {@link User} a entidades {@link UserEntity}
 * y viceversa, utilizando el mapper {@link UserPatientMapper}, cumpliendo con los principios de la arquitectura hexagonal.
 * También encapsula el manejo de excepciones específicas para una respuesta controlada.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Adapter
 * 🧱 Capa: Infrastructure → Adaptador de persistencia
 * 🔁 Flujo: Dominio ↔ Persistencia
 */
@Repository
public class UserPatientAdapter implements User_PatientRepositoryOutPort {

    private final SpringDataUserRepository crud;

    /**
     * Constructor que inyecta el repositorio Spring Data.
     *
     * @param crud instancia del repositorio JPA
     */
    public UserPatientAdapter(SpringDataUserRepository crud) {
        this.crud = crud;
    }

    /**
     * Consulta todos los usuarios registrados en la base de datos.
     *
     * @return lista de usuarios como modelos de dominio
     * @throws InternalServerException si ocurre un error inesperado en la capa de persistencia
     */
    @Override
    public List<User> findAll() {
        try {
            List<UserEntity> saved = crud.findAll();
            return UserPatientMapper.toDomain(saved);
        } catch (RuntimeException e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }

    /**
     * Consulta un usuario por su ID.
     *
     * @param id identificador único
     * @return usuario encontrado como modelo de dominio
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    @Override
    public User findById(Long id) {
        try {
            return crud.findById(id)
                    .map(UserPatientMapper::toUser)
                    .orElseThrow(() -> new ResourceNotFoundException("User no found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Persiste un nuevo usuario en la base de datos.
     *
     * @param user objeto del modelo de dominio
     * @return usuario persistido como modelo de dominio
     * @throws InternalServerException si ocurre un error inesperado en la capa de persistencia
     */
    @Override
    public User save(User user) {
        try {
            UserEntity send = UserPatientMapper.toEntity(user);
            return UserPatientMapper.toUser(crud.save(send));
        } catch (RuntimeException e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id identificador único
     * @return true si fue eliminado, false si no existía
     * @throws EmptyResultDataAccessException si el ID no existe en la base de datos
     */
    @Override
    public boolean deleteById(Long id) {
        if (crud.existsById(id)){
            throw new ResourceNotFoundException("User no found");
        }
        crud.deleteById(id);
        return true;
    }

    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param user objeto del modelo de dominio con datos actualizados
     * @return usuario actualizado como modelo de dominio
     * @throws RuntimeException si ocurre un error inesperado
     */
    @Override
    public User update(User user) {

       Optional<UserEntity> existing = crud.findById(user.id());
       if (existing.isEmpty()) {
           throw new ResourceNotFoundException("User no found, no se encontro el usuario a actualizar");
       }
       return UserPatientMapper.toUser(
               crud.save(
                       UserPatientMapper.updateEntity(
                               user, existing.get()
                       )
               ));
    }
}
