package com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto;

import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de salida para representar una cita médica.
 *
 * Este objeto se utiliza en las respuestas HTTP para enviar los datos de una cita al cliente.
 */
@Schema(description = "DTO de salida que representa una cita médica")
public record CitaResponse(

        @Schema(
                description = "Identificador único de la cita",
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


*/
) {}
