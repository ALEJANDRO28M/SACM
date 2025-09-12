package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de entrada para operaciones relacionadas con doctores.
 *
 * Este objeto se utiliza para recibir los datos necesarios al momento de crear o actualizar
 * un perfil médico en el sistema.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto
 * 🧱 Capa: Infrastructure (DTO para controlador)
 * 🎯 Uso: Entrada en endpoints HTTP (POST/PUT)
 */
@Schema(description = "DTO de entrada para registrar o actualizar un doctor")
public record DoctorRequest(

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
