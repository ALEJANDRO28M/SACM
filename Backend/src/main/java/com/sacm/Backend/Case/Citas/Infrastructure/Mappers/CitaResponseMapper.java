package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;

import java.util.List;

/**
 * Mapper encargado de convertir objetos del modelo de dominio {@link Citas}
 * en DTOs de salida {@link CitaResponse}, utilizados en la capa de exposición (controladores).
 *
 * Este componente forma parte de la infraestructura y permite desacoplar la lógica de negocio
 * de la representación HTTP, siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Citas.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio → DTO
 * 🔁 Patrón: Domain Model → DTO
 */
public class CitaResponseMapper {

    /**
     * Convierte una lista de objetos {@link Citas} en una lista de {@link CitaResponse}.
     *
     * @param citas lista de modelos de dominio
     * @return lista de DTOs para respuesta HTTP
     */
    public static List<CitaResponse> toListResponseDto(List<Citas> citas) {
        return citas.stream()
                .map(cita -> new CitaResponse(
                        cita.id(),
                        cita.fecha(),
                        cita.motivo()
/*                      cita.historialMedico(),
                        cita.user() */
                ))
                .toList();
    }

    /**
     * Convierte un objeto {@link Citas} en un {@link CitaResponse}.
     *
     * @param cita modelo de dominio
     * @return DTO para respuesta HTTP
     */
    public static CitaResponse citaToResponseDtoMapper(Citas cita) {
        return new CitaResponse(
                cita.id(),
                cita.fecha(),
                cita.motivo()
        );
    }
}
