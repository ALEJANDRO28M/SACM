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
        summary = "Creación de usuario administrativo",
        description = """
        Este endpoint permite registrar un nuevo usuario administrativo en el sistema.
        Los campos requeridos son: usuario, email, correo y contraseña.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Usuario creado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Usuario creado exitosamente!",
                  "errorCode": "200 OK",
                  "details": "Usuario registrado correctamente en el sistema",
                  "path": "Api/CreateUserLogin"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la creación del usuario",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 400,
                  "message": "Error al crear el usuario!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "Fallo en las validaciones del DTO de entrada",
                  "path": "Api/CreateUserLogin"
                }
                """
                        )
                )
        )
})
public @interface CreateUserPatientDoc {
}
