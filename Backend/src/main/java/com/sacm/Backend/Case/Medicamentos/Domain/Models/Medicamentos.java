package com.sacm.Backend.Case.Medicamentos.Domain.Models;

public record Medicamentos(
        Long id,
        String nombre,
        String descripcion,
        String dosis,
        String frecuencia
) {
}
