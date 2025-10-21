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
        summary = "Creación de medicamento",
        description = """
        Este endpoint permite registrar un nuevo medicamento en el sistema.
        Los datos requeridos incluyen: ID, NOMBRE, DESCRIPCIÓN, DOSIS y FRECUENCIA.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Medicamento creado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Medicamento creado correctamente!",
                  "errorCode": "200 OK",
                  "details": "El medicamento fue registrado exitosamente en el sistema",
                  "path": "Api/newMedicine"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la creación del medicamento",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 400,
                  "message": "Error al crear el medicamento!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "Fallo en las validaciones del DTO de entrada",
                  "path": "Api/newMedicine"
                }
                """
                        )
                )
        )
})
public @interface CreateMedicalDoc {
}
