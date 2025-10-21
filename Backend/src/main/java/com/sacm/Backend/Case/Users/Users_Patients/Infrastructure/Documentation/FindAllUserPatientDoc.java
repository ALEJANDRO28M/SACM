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
        summary = "Consulta de todos los usuarios registrados",
        description = """
        Este endpoint retorna una lista con los datos de todos los usuarios almacenados 
        en la base de datos, incluyendo ID, nombre de usuario, contraseña y correo electrónico.
        """
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Consulta exitosa de usuarios",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Usuarios obtenidos correctamente!",
                  "errorCode": "200 OK",
                  "details": "Flujo procesado correctamente",
                  "path": "Api/findAllUserLogin"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Error inesperado al consultar los usuarios",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 500,
                  "message": "Error al consultar los usuarios",
                  "errorCode": "500 INTERNAL_SERVER_ERROR",
                  "details": "Error inesperado en la capa de persistencia",
                  "path": "Api/findAllUserLogin"
                }
                """
                        )
                )
        )
})
public @interface FindAllUserPatientDoc {
}
