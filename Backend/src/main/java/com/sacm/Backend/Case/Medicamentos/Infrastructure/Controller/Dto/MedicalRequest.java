package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto;

public record MedicalRequest(
        Long id,
        String nombre,
        String descripcion,
        String dosis,
        String frecuencia
        ) {

}
