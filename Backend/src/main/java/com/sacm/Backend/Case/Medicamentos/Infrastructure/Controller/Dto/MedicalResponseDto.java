package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de salida para representar un medicamento registrado en el sistema.
 *
 * Este objeto se utiliza en las respuestas HTTP para enviar los datos de un medicamento
 * al cliente, ya sea en consultas individuales o listados.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto
 * 🧱 Capa: Infrastructure (DTO para controlador)
 * 🎯 Uso: Salida en endpoints HTTP (GET/POST/PUT)
 */
@Schema(description = "DTO de salida que representa un medicamento registrado")
public record MedicalResponseDto(

        @Schema(
                description = "Identificador único del medicamento",
                example = "101"
        )
        Long id,

        @Schema(
                description = "Nombre comercial o genérico del medicamento",
                example = "Paracetamol"
        )
        String nombre,

        @Schema(
                description = "Descripción breve del medicamento y su uso",
                example = "Analgésico utilizado para aliviar dolores leves o moderados"
        )
        String descripcion,

        @Schema(
                description = "Dosis recomendada del medicamento",
                example = "500mg"
        )
        String dosis,

        @Schema(
                description = "Frecuencia de administración del medicamento",
                example = "Cada 8 horas"
        )
        String frecuencia
) {}
