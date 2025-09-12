package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de salida que representa la información pública de un doctor registrado en el sistema.
 *
 * Este objeto se utiliza en las respuestas HTTP para enviar los datos del doctor
 * al cliente, ya sea en consultas individuales o listados.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto
 * 🧱 Capa: Infrastructure (DTO para controlador)
 * 🎯 Uso: Salida en endpoints HTTP (GET/POST/PUT)
 */
@Schema(description = "DTO de salida que representa un doctor registrado")
public record DoctorResponse(

        @Schema(
                description = "Identificador único del doctor",
                example = "101"
        )
        Long id,

        @Schema(
                description = "Nombre del doctor",
                example = "Carlos"
        )
        String nombre,

        @Schema(
                description = "Apellido del doctor",
                example = "Ramírez"
        )
        String apellido,

        @Schema(
                description = "Especialidad médica del doctor",
                example = "Cardiología"
        )
        String especialidad,

        @Schema(
                description = "Número de teléfono de contacto",
                example = "+57 3101234567"
        )
        String telefono,

        @Schema(
                description = "Correo electrónico profesional del doctor",
                example = "carlos.ramirez@hospital.com"
        )
        String email
) {}
