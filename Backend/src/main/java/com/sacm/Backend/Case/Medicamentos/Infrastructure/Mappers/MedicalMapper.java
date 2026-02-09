package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;

import java.util.List;

/**
 * Mapper encargado de transformar entre el modelo de dominio {@link Medicamentos}
 * y la entidad de persistencia {@link MedicalEntity}.
 *
 * Este componente permite desacoplar la lógica de negocio de la capa de infraestructura,
 * facilitando la interoperabilidad entre capas en una arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio ↔ Persistencia
 * 🔁 Flujo: Domain ↔ Entity
 */
public class MedicalMapper {

    /**
     * Convierte una entidad {@link MedicalEntity} en un objeto del modelo de dominio {@link Medicamentos}.
     *
     * @param medicalEntity entidad obtenida desde la base de datos
     * @return instancia del modelo de dominio
     */
    public static Medicamentos toDomain(MedicalEntity medicalEntity) {
        return new Medicamentos(
                medicalEntity.getId(),
                medicalEntity.getName(),
                medicalEntity.getDescription(),
                medicalEntity.getDose(),
                medicalEntity.getFrequency()
        );
    }

    /**
     * Convierte un objeto del modelo de dominio {@link Medicamentos} en una entidad {@link MedicalEntity}
     * para ser persistido en la base de datos.
     *
     * @param medical instancia del modelo de dominio
     * @return entidad lista para persistencia
     */
    public static MedicalEntity toEntity(Medicamentos medical) {
        return new MedicalEntity(
                medical.id(),
                medical.nombre(),
                medical.descripcion(),
                medical.dosis(),
                medical.frecuencia()
        );
    }

    /**
     * Convierte una lista de entidades {@link MedicalEntity} en una lista de objetos del modelo de dominio {@link Medicamentos}.
     *
     * @param medicalEntity lista de entidades persistidas
     * @return lista de modelos de dominio
     */
    public static List<Medicamentos> listMedicamentos(List<MedicalEntity> medicalEntity) {
        return medicalEntity.stream()
                .map(entity -> new Medicamentos(
                        entity.getId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getDose(),
                        entity.getFrequency()
                ))
                .toList();
    }
}
