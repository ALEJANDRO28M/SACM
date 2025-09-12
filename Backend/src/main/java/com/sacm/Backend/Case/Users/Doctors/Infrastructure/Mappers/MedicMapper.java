package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;

import java.util.List;

/**
 * Mapper encargado de transformar entre el modelo de dominio {@link Medico}
 * y la entidad de persistencia {@link MedicEntity}.
 *
 * Este componente permite desacoplar la lógica de negocio de la capa de infraestructura,
 * facilitando la interoperabilidad entre capas en una arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio ↔ Persistencia
 * 🔁 Flujo: Domain ↔ Entity
 */
public class MedicMapper {

    /**
     * Convierte un objeto del modelo de dominio {@link Medico} en una entidad {@link MedicEntity}
     * para ser persistido en la base de datos.
     *
     * @param medico instancia del modelo de dominio
     * @return entidad lista para persistencia
     */
    public static MedicEntity toEntity(Medico medico) {
        return new MedicEntity(
                medico.id(),
                medico.nombre(),
                medico.apellido(),
                medico.especialidad(),
                medico.telefono(),
                medico.email()
        );
    }

    /**
     * Convierte una entidad {@link MedicEntity} en un objeto del modelo de dominio {@link Medico}.
     *
     * @param medicEntity entidad obtenida desde la base de datos
     * @return instancia del modelo de dominio
     */
    public static Medico toDomain(MedicEntity medicEntity) {
        return new Medico(
                medicEntity.getId(),
                medicEntity.getNombre(),
                medicEntity.getApellido(),
                medicEntity.getEspecialidad(),
                medicEntity.getTelefono(),
                medicEntity.getEmail()
        );
    }

    /**
     * Convierte una lista de entidades {@link MedicEntity} en una lista de objetos del modelo de dominio {@link Medico}.
     *
     * @param medicEntity lista de entidades persistidas
     * @return lista de modelos de dominio
     */
    public static List<Medico> toDomainList(List<MedicEntity> medicEntity) {
        return medicEntity.stream()
                .map(entity -> new Medico(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getApellido(),
                        entity.getEspecialidad(),
                        entity.getTelefono(),
                        entity.getEmail()
                ))
                .toList();
    }
}
