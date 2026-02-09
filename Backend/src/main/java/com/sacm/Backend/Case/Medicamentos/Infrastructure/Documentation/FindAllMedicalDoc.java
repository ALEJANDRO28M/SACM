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
        summary = "Consulta de todos los medicamentos",
        description = """
        Este endpoint retorna una lista con todos los medicamentos almacenados 
        en la base de datos, incluyendo ID, nombre, descripción, dosis y frecuencia.
        """
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Consulta exitosa de medicamentos",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Medicamentos obtenidos correctamente!",
                  "errorCode": "200 OK",
                  "details": "Flujo procesado correctamente",
                  "path": "Api/findAllMedicines"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Error inesperado al consultar los medicamentos",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 500,
                  "message": "Error al consultar los medicamentos",
                  "errorCode": "500 INTERNAL_SERVER_ERROR",
                  "details": "Error inesperado en la capa de persistencia",
                  "path": "Api/findAllMedicines"
                }
                """
                        )
                )
        )
})
public @interface FindAllMedicalDoc {
}
