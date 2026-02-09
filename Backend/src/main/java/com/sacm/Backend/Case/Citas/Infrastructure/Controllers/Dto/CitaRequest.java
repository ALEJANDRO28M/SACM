package com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto;


import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de entrada para crear o actualizar una cita médica.
 *
 * Este objeto se utiliza en los endpoints HTTP para recibir los datos necesarios de una cita.
 */
@Schema(description = "DTO de entrada para operaciones de citas médicas")
public record CitaRequest(

        @Schema(
                description = "Identificador único de la cita (usado en actualizaciones)",
                example = "1"
        )
        long id,

        @Schema(
                description = "Fecha de la cita en formato ISO (yyyy-MM-dd)",
                example = "2025-09-10"
        )
        String fecha,

        @Schema(
                description = "Motivo o descripción breve de la cita médica",
                example = "Consulta general por dolor abdominal"
        )
        String motivo,

        @Schema(description = "Usuario/paciente que tiene la cita")
        UserEntity user

/*
    @Schema(description = "Historial médico asociado a la cita")
    HistorialMedico historialMedico,

    @Schema(description = "Usuario/paciente que solicita la cita")
    User_Of_Patients user
*/
) {}
