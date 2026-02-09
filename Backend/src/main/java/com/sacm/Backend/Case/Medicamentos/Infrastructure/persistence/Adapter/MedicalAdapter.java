package com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Medicamentos.Application.Port.Out.MedicalRepositoryOutPort;
import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.MedicalMapper;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Repositories.SpringDataMedicalRepository;
import com.sacm.Backend.Common.Exception.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Adaptador de persistencia que implementa el puerto de salida {@link MedicalRepositoryOutPort}
 * para interactuar con la base de datos mediante el repositorio Spring Data {@link SpringDataMedicalRepository}.
 *
 * Este componente traduce objetos del modelo de dominio {@link Medicamentos} a entidades {@link MedicalEntity}
 * y viceversa, utilizando el mapper {@link MedicalMapper}, cumpliendo con los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Adapter
 * 🧱 Capa: Infrastructure → Adaptador de persistencia
 * 🔁 Flujo: Dominio ↔ Persistencia
 */
@Repository
public class MedicalAdapter implements MedicalRepositoryOutPort {

    private final SpringDataMedicalRepository crud;

    /**
     * Constructor que inyecta el repositorio Spring Data.
     *
     * @param crud instancia del repositorio JPA
     */
    public MedicalAdapter(SpringDataMedicalRepository crud) {
        this.crud = crud;
    }

    /**
     * Persiste un medicamento en la base de datos.
     *
     * @param medicine objeto del modelo de dominio
     * @return medicamento persistido como modelo de dominio
     */
    @Override
    public Medicamentos create(Medicamentos medicine) {
        MedicalEntity toEntity = MedicalMapper.toEntity(medicine);
        return MedicalMapper.toDomain(crud.save(toEntity));
    }

    /**
     * Consulta todos los medicamentos registrados.
     *
     * @return lista de medicamentos como modelos de dominio
     */
    @Override
    public List<Medicamentos> findAll() {
        List<MedicalEntity> medicEntity = crud.findAll();
        return MedicalMapper.listMedicamentos(medicEntity);
    }

    /**
     * Consulta un medicamento por su ID.
     *
     * @param id identificador único
     * @return medicamento encontrado como modelo de dominio
     * @throws RuntimeException si no se encuentra el medicamento
     */
    @Override
    public Medicamentos findById(Long id) {
        return crud.findById(id)
                .map(MedicalMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Medicament no found"));
    }

    /**
     * Actualiza los datos de un medicamento existente.
     *
     * @param medic objeto del modelo de dominio con datos actualizados
     * @return medicamento actualizado como modelo de dominio
     */
    @Override
    public Medicamentos update(Medicamentos medic) {
        MedicalEntity toEntity = MedicalMapper.toEntity(medic);
        return MedicalMapper.toDomain(crud.save(toEntity));
    }

    /**
     * Elimina un medicamento por su ID.
     *
     * @param id identificador único
     * @return true si fue eliminado, false si no existía
     */
    @Override
    public boolean delete(Long id) {
        if (!crud.existsById(id)) {
            throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
        }
       crud.deleteById(id);
       return true;
    }
}
