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
        summary = "Eliminación de medicamento",
        description = """
        Este endpoint permite eliminar un medicamento de la base de datos
        mediante su identificador único.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Medicamento eliminado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Medicamento eliminado correctamente!",
                  "errorCode": "200 OK",
                  "details": "El medicamento fue eliminado del sistema",
                  "path": "Api/deleteMedicine/{id}"
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
                  "message": "Error al eliminar el medicamento!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró un medicamento con el ID proporcionado",
                  "path": "Api/deleteMedicine/{id}"
                }
                """
                        )
                )
        )
})
public @interface DeleteMedicalDoc {
}
