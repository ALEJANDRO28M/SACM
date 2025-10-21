package com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Users.Doctors.Application.Port.Out.MedicRepositoryOutPort;
import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.MedicMapper;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Repositories.SpringDataMedicRepository;
import com.sacm.Backend.Common.Exception.EmptyResultDataAccessException;
import com.sacm.Backend.Common.Exception.InternalServerException;
import com.sacm.Backend.Common.Exception.MethodArgumentNotValidException;
import com.sacm.Backend.Common.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida {@link MedicRepositoryOutPort}
 * para interactuar con la base de datos mediante el repositorio Spring Data {@link SpringDataMedicRepository}.
 *
 * Este componente traduce objetos del modelo de dominio {@link Medico} a entidades {@link MedicEntity}
 * y viceversa, utilizando el mapper {@link MedicMapper}, cumpliendo con los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Adapter
 * 🧱 Capa: Infrastructure → Adaptador de persistencia
 * 🔁 Flujo: Dominio ↔ Persistencia
 */
@Repository
public class MedicAdapter implements MedicRepositoryOutPort {

    private final SpringDataMedicRepository crud;

    /**
     * Constructor que inyecta el repositorio Spring Data.
     *
     * @param crud instancia del repositorio JPA
     */
    public MedicAdapter(SpringDataMedicRepository crud) {
        this.crud = crud;
    }

    /**
     * Persiste un nuevo doctor en la base de datos.
     *
     * @param medico objeto del modelo de dominio
     * @return doctor persistido como modelo de dominio
     */
    @Override
    public Medico createMedico(Medico medico) {
        try{
            MedicEntity save = crud.save(MedicMapper.toEntity(medico));
            return MedicMapper.toDomain(save);
        }catch (Exception ex){
            throw new MethodArgumentNotValidException("FALLO EN LAS VALIDACIONES DEL DTO A CREAR!");
        }
    }

    /**
     * Actualiza los datos de un doctor existente.
     *
     * @param medico objeto del modelo de dominio con datos actualizados
     * @return doctor actualizado como modelo de dominio
     */
    @Override
    public Medico updateMedico(Medico medico) {

        Optional<MedicEntity> existing = crud.findById(medico.id());

        if (existing.isEmpty()) {
            throw new ResourceNotFoundException("User not found!, no se encontro el usuario a actualizar");
        }

        final MedicEntity updateEntity = existing.get();
        updateEntity.setNombre(medico.nombre());
        updateEntity.setApellido(medico.apellido());
        updateEntity.setEmail(medico.email());
        updateEntity.setEspecialidad(medico.especialidad());
        updateEntity.setTelefono(medico.telefono());

      return MedicMapper.toDomain(crud.save(updateEntity));
    }

    /**
     * Elimina un doctor por su ID.
     *
     * @param id identificador único
     * @return true si fue eliminado, false si no existía
     */
    @Override
    public boolean deleteMedico(Long id) {
        if (!crud.existsById(id)) {
            throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
        }
        crud.deleteById(id);
        return true;
    }


    /**
     * Consulta todos los doctores registrados.
     *
     * @return lista de doctores como modelos de dominio
     */
    @Override
    public List<Medico> findAllMedico() {
        try {
            List<MedicEntity> save = crud.findAll();
            return MedicMapper.toDomainList(save);
        } catch (Exception e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }

    /**
     * Consulta un doctor por su ID.
     *
     * @param id identificador único
     * @return doctor encontrado como modelo de dominio
     * @throws RuntimeException si no se encuentra el doctor
     */
    @Override
    public Medico findMedicoById(Long id) {
        return crud.findById(id)
                .map(MedicMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró un usuario con el ID proporcionado"));
    }
}
