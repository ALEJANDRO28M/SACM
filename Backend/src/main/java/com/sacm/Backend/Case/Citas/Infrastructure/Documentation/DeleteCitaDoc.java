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
        summary = "Eliminación de cita médica",
        description = """
        Este endpoint permite eliminar una cita médica de la base de datos
        mediante su identificador único.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Cita eliminada exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Cita eliminada correctamente!",
                  "errorCode": "200 OK",
                  "details": "La cita fue eliminada del sistema",
                  "path": "Api/CityDeleteById/{id}"
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
                  "message": "Error al eliminar la cita!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró una cita con el ID proporcionado",
                  "path": "Api/CityDeleteById/{id}"
                }
                """
                        )
                )
        )
})
public @interface DeleteCitaDoc {
}
