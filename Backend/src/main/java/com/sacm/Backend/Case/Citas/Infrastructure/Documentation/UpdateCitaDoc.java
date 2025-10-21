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
        summary = "Actualización de cita médica",
        description = """
        Este endpoint permite actualizar los datos de una cita médica existente.
        Campos actualizables: FECHA, MOTIVO.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Cita actualizada correctamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Cita actualizada correctamente!",
                  "errorCode": "200 OK",
                  "details": "Los datos de la cita fueron modificados exitosamente",
                  "path": "Api/CityUpdate"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la actualización de la cita",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 400,
                  "message": "Error al actualizar la cita!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "Fallo en las validaciones del DTO de entrada",
                  "path": "Api/CityUpdate"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Cita no encontrada",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 404,
                  "message": "Cita no encontrada!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró la cita a actualizar",
                  "path": "Api/CityUpdate"
                }
                """
                        )
                )
        )
})
public @interface UpdateCitaDoc {
}
