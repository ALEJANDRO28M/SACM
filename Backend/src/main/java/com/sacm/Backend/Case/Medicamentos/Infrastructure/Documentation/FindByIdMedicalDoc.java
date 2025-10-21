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
        summary = "Obtención de medicamento por ID",
        description = """
        Este endpoint permite obtener la información de un medicamento 
        mediante su identificador único. Retorna los siguientes datos:
        ID, NOMBRE, DESCRIPCIÓN, DOSIS, FRECUENCIA.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Medicamento encontrado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Medicamento obtenido correctamente!",
                  "errorCode": "200 OK",
                  "details": "El medicamento fue encontrado en el sistema",
                  "path": "Api/findMedicine/{id}",
                  "data": {
                    "id": 1,
                    "nombre": "Paracetamol",
                    "descripcion": "Analgésico para dolores leves",
                    "dosis": "500mg",
                    "frecuencia": "Cada 8 horas"
                  }
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
                  "details": "No se encontró un medicamento con el ID proporcionado",
                  "path": "Api/findMedicine/{id}"
                }
                """
                        )
                )
        )
})
public @interface FindByIdMedicalDoc {
}
