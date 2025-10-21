package com.sacm.Backend.Case.Medicamentos.Infrastructure.Documentation;

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
        summary = "Actualización de medicamento",
        description = """
        Este endpoint permite actualizar los datos de un medicamento existente.
        Campos actualizables: NOMBRE, DESCRIPCIÓN, DOSIS, FRECUENCIA.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Medicamento actualizado correctamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Medicamento actualizado correctamente!",
                  "errorCode": "200 OK",
                  "details": "Los datos del medicamento fueron modificados exitosamente",
                  "path": "Api/updateMedicine"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la actualización del medicamento",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 400,
                  "message": "Error al actualizar el medicamento!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "Fallo en las validaciones del DTO de entrada",
                  "path": "Api/updateMedicine"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Medicamento no encontrado",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 404,
                  "message": "Medicamento no encontrado!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró el medicamento a actualizar",
                  "path": "Api/updateMedicine"
                }
                """
                        )
                )
        )
})
public @interface UpdateMedicalDoc {
}
