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
        summary = "Consulta de todas las citas médicas",
        description = """
        Este endpoint retorna una lista con todas las citas médicas almacenadas 
        en la base de datos, incluyendo ID, fecha y motivo de cada cita.
        """
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Consulta exitosa de citas",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Citas obtenidas correctamente!",
                  "errorCode": "200 OK",
                  "details": "Flujo procesado correctamente",
                  "path": "Api/CityPatient"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Error inesperado al consultar las citas",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 500,
                  "message": "Error al consultar las citas",
                  "errorCode": "500 INTERNAL_SERVER_ERROR",
                  "details": "Error inesperado en la capa de persistencia",
                  "path": "Api/CityPatient"
                }
                """
                        )
                )
        )
})
public @interface FindAllCitaDoc {
}
