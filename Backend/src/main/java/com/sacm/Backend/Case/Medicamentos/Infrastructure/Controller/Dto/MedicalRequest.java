package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de entrada para operaciones relacionadas con medicamentos.
 *
 * Este objeto se utiliza para recibir los datos necesarios al momento de crear o actualizar
 * un medicamento en el sistema.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto
 * 🧱 Capa: Infrastructure (DTO para controlador)
 * 🎯 Uso: Entrada en endpoints HTTP (POST/PUT)
 */
@Schema(description = "DTO de entrada para registrar o actualizar medicamentos")
public record MedicalRequest(

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
