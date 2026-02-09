package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;

import java.util.List;

/**
 * Mapper encargado de transformar entre el modelo de dominio {@link Citas}
 * y la entidad de persistencia {@link CitasEntitys}.
 *
 * Este componente permite desacoplar la lógica de negocio de la capa de infraestructura,
 * facilitando la interoperabilidad entre capas en una arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Citas.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio ↔ Persistencia
 * 🔁 Flujo: Domain ↔ Entity
 */
public class CitasMapper {

    /**
     * Convierte un objeto del modelo de dominio {@link Citas} en una entidad {@link CitasEntitys}
     * para ser persistido en la base de datos.
     *
     * @param domain instancia del modelo de dominio
     * @return entidad lista para persistencia
     */
    public static CitasEntitys toEntity(Citas domain) {
        return new CitasEntitys(
                domain.id(),
                domain.fecha(),
                domain.motivo(),
                domain.user()
/*          domain.historialMedico(),
            domain.user() */
        );
    }

    /**
     * Convierte una entidad {@link CitasEntitys} en un objeto del modelo de dominio {@link Citas}.
     *
     * @param entity entidad obtenida desde la base de datos
     * @return instancia del modelo de dominio
     */
    public static Citas toDomain(CitasEntitys entity) {
        return new Citas(
                entity.getId(),
                entity.getFecha(),
                entity.getMotivo(),
                entity.getUser()
/*          entity.getHistorialMedico(),
            entity.getUser_Of_Patients() */
        );
    }

    /**
     * Convierte una lista de entidades {@link CitasEntitys} en una lista de objetos del modelo de dominio {@link Citas}.
     *
     * @param entity lista de entidades persistidas
     * @return lista de modelos de dominio
     */
    public static List<Citas> toListCitas(List<CitasEntitys> entity) {
        return entity.stream()
                .map(citasEntitys -> new Citas(
                        citasEntitys.getId(),
                        citasEntitys.getFecha(),
                        citasEntitys.getMotivo(),
                        citasEntitys.getUser()
/*              citasEntitys.getHistorialMedico(),
                citasEntitys.getUser_Of_Patients() */
                ))
                .toList();
    }
}
