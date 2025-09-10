package com.sacm.Backend.Case.Login.Infrastructure.Documentation;

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
        summary = "Obtención de usuario por ID",
        description = """
        Este endpoint permite obtener la información de un usuario administrativo 
        mediante su identificador único. Retorna los siguientes datos:
        USUARIO, EMAIL, CORREO.
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
                  "message": "User retrieved successfully!",
                  "errorCode": "200 OK",
                  "details": "Usuario encontrado correctamente",
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
                  "message": "User not found!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "No se encontró un usuario con el ID proporcionado",
                  "path": "Api/FindById/{id}"
                }
                """
                        )
                )
        )
})

public @interface FindByIdUserLoginDoc {
}
