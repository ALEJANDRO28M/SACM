package com.sacm.Backend.Case.Citas.Infrastructure.Documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Operation(
        summary = "Creación de cita médica",
        description = """
        Este endpoint permite registrar una nueva cita médica en el sistema.
        Los datos requeridos incluyen: ID, FECHA y MOTIVO de la cita.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Cita creada exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Cita creada correctamente!",
                  "errorCode": "200 OK",
                  "details": "La cita fue registrada exitosamente en el sistema",
                  "path": "Api/create"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la creación de la cita",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 400,
                  "message": "Error al crear la cita!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "Fallo en las validaciones del DTO de entrada",
                  "path": "Api/create"
                }
                """
                        )
                )
        )
})
public @interface CreateCitaDoc {
}
