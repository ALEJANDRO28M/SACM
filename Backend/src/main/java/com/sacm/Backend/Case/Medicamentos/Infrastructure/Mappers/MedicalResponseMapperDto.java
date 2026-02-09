package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalResponseDto;

import java.util.List;

/**
 * Mapper encargado de transformar objetos del modelo de dominio {@link Medicamentos}
 * en DTOs de salida {@link MedicalResponseDto}, utilizados en la capa de exposición (controladores).
 *
 * Este componente permite desacoplar la lógica de negocio de la representación HTTP,
 * siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio → DTO
 * 🔁 Flujo: Domain Model → Response DTO
 */
public class MedicalResponseMapperDto {

    /**
     * Convierte una lista de objetos {@link Medicamentos} en una lista de {@link MedicalResponseDto}.
     *
     * @param medical lista de modelos de dominio
     * @return lista de DTOs para respuesta HTTP
     */
    public static List<MedicalResponseDto> listMedicamentos(List<Medicamentos> medical) {
        return medical.stream()
                .map(entity -> new MedicalResponseDto(
                        entity.id(),
                        entity.nombre(),
                        entity.descripcion(),
                        entity.dosis(),
                        entity.frecuencia()
                ))
                .toList();
    }

    /**
     * Convierte un objeto {@link Medicamentos} en un {@link MedicalResponseDto}.
     *
     * @param medicamento modelo de dominio
     * @return DTO para respuesta HTTP
     */
    public static MedicalResponseDto toResponseDto(Medicamentos medicamento) {
        return new MedicalResponseDto(
                medicamento.id(),
                medicamento.nombre(),
                medicamento.descripcion(),
                medicamento.dosis(),
                medicamento.frecuencia()
        );
    }
}
