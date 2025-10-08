package com.sacm.Backend.Case.Login.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import com.sacm.Backend.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Common.Exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida {@link UserLoginRepositoryOutPort}.
 * Se encarga de interactuar con la base de datos mediante {@link SpringDataLogin},
 * aplicar codificación de contraseñas con {@link SecurityService},
 * y mapear entre entidades y modelos de dominio usando {@link UserLoginMapper}.
 */
@Slf4j
@Repository
public class LoginAdapter implements UserLoginRepositoryOutPort {

    SpringDataLogin crud;
    SecurityService security;

    /**
     * Constructor del adaptador de persistencia.
     *
     * @param crud repositorio Spring Data JPA
     * @param security servicio de codificación de contraseñas
     */
    public LoginAdapter(SpringDataLogin crud, SecurityService security) {
        this.crud = crud;
        this.security = security;
    }

    /**
     * Obtiene todos los usuarios registrados en la base de datos.
     *
     * @return lista de modelos de dominio {@link UserLogin}
     * @throws InternalServerException si ocurre un error inesperado en la persistencia
     */
    @Override
    public List<UserLogin> findAll() {
        try {
            return UserLoginMapper.toDomain(crud.findAll());
        } catch (RuntimeException e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id identificador único del usuario
     * @return modelo de dominio {@link UserLogin}
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    @Override
    public UserLogin findById(Long id) {
        return crud.findById(id)
                .map(UserLoginMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("User no found"));
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id identificador único del usuario
     * @return true si la eliminación fue exitosa
     * @throws EmptyResultDataAccessException si el ID no existe en la base de datos
     */
    @Override
    public Boolean deleteById(Long id) {
        try {
            crud.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
        }
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param user modelo de dominio con los datos del usuario
     * @return modelo de dominio persistido
     * @throws MethodArgumentNotValidException si ocurre un error en la validación o persistencia
     */
    @Override
    public UserLogin create(UserLogin user) {
        try {
            String encoded = security.encode(user.password());
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);
            return UserLoginMapper.toDomain(crud.save(entity));
        } catch (Exception e) {
            throw new MethodArgumentNotValidException("FALLO EN LAS VALIDACIONES DEL DTO A CREAR!");
        }
    }

    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param user modelo de dominio con los datos actualizados
     * @return modelo de dominio actualizado
     * @throws MethodArgumentNotValidException si ocurre un error en la validación o persistencia
     */
    @Override
    public UserLogin update(UserLogin user) {

        Optional<UserLoginEntity> existenteOpt = crud.findById(user.id());

        if (existenteOpt.isEmpty()) {
            throw new ResourceNotFoundException("User not found, No se encontró el usuario a actualizar");
        }
        return UserLoginMapper.toDomain(
                crud.save(
                        UserLoginMapper.updateEntity(
                                user, existenteOpt.get()
                        )));
    }


    @Override
        public Map<String,Object> LoginUser(UserLogin login) {
        try {
            Optional<UserLoginEntity> user = crud.findByUser(login.user());
            if (user.isPresent()) {
                String password = user.get().getPassword();
                security.matches(login.password(), password);

                Map<String, Object> map = new HashMap<>();
                System.out.println("Este es el doctor: " + user.get().getDoctor());////////////
                map.put("doctor", user.get().getDoctor());
                return map;

            } else {
                throw new UserLoginInvalidException("Usuario no encontrado");
            }
        } catch (RuntimeException e) {
            throw new UserLoginInvalidException("Password incorrecta");
        }
        }
        }


