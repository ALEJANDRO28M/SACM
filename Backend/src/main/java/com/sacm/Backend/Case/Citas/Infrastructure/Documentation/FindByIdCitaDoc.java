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
        summary = "Obtención de cita médica por ID",
        description = """
        Este endpoint permite obtener la información de una cita médica 
        mediante su identificador único. Retorna los siguientes datos:
        ID, FECHA, MOTIVO.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Cita encontrada exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Cita obtenida correctamente!",
                  "errorCode": "200 OK",
                  "details": "La cita fue encontrada en el sistema",
                  "path": "Api/CityFindById/{id}",
                  "data": {
                    "id": 1,
                    "fecha": "2025-09-10",
                    "motivo": "Consulta general"
                  }
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
                  "details": "No se encontró una cita con el ID proporcionado",
                  "path": "Api/CityFindById/{id}"
                }
                """
                        )
                )
        )
})
public @interface FindByIdCitaDoc {
}
