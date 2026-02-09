package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation;

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
        summary = "Creacion de usuarion",
        description = """
                Se crea un usuario administrativo, que contenga los siguientes datos:
                USUARIO, EMAIL, CORREO, PASSWORD.
                """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                  {
                  "statusCode": 200,
                  "message": "User create Successfully!",
                  "errorCode": "200 OK",
                  "details": "Usuario creado correctamente",
                  "path": "Api/CreateUserLogin"
                  }
                  """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                  {                                {
                  "statusCode": 400,
                  "message": "User create failed!",
                  "errorCode": "400 BAD_REQUEST",
                  "details": "FALLO EN LAS VALIDACIONES DEL DTO A CREAR!",
                  "path": "Api/CreateUserLogin"
                  }
                  """
                        )
                )
        )
})
public @interface CreateUserLoginDoc {
}
