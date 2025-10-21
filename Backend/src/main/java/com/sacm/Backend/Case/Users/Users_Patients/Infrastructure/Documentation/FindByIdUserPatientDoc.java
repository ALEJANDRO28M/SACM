package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Documentation;

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
        summary = "Consulta de usuario por ID",
        description = """
        Este endpoint permite obtener la información de un usuario administrativo 
        mediante su identificador único. Retorna los siguientes datos:
        ID, nombre de usuario, correo electrónico.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Usuario encontrado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Usuario obtenido correctamente!",
                  "errorCode": "200 OK",
                  "details": "Usuario encontrado en la base de datos",
                  "path": "Api/GetUserById",
                  "data": {
                    "id": 1,
                    "username": "adminUser",
                    "email": "admin@example.com"
                  }
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Usuario no encontrado",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 404,
                  "message": "Usuario no encontrado!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró un usuario con el ID proporcionado",
                  "path": "Api/GetUserById/{id}"
                }
                """
                        )
                )
        )
})
public @interface FindByIdUserPatientDoc {
}
