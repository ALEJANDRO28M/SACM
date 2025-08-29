package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto;

public record MedicalResponseDto(
        Long id,
        String nombre,
        String descripcion,
        String dosis,
        String frecuencia
) {
}
