package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

/**
 * Mapper encargado de convertir un {@link CitaRequest} (DTO de entrada desde el controlador)
 * en un objeto de dominio {@link Citas}, utilizado en la capa de aplicación.
 *
 * Este mapper forma parte de la infraestructura y permite desacoplar la capa de exposición
 * del modelo de negocio, siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Citas.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo DTO → Dominio
 * 🔁 Patrón: DTO → Domain Model
 */
public class CitaRequestMapper {

    /**
     * Convierte un {@link CitaRequest} en un objeto {@link Citas}.
     *
     * @param citaRequest DTO recibido desde el cliente
     * @return instancia del modelo de dominio {@link Citas}
     */
    public static Citas requestToCita(CitaRequest citaRequest) {
        return new Citas(
                citaRequest.id(),
                citaRequest.fecha(),
                citaRequest.motivo(),
                citaRequest.user()
/*          citaRequest.historialMedico(),
            citaRequest.user() */
        );
    }
}
