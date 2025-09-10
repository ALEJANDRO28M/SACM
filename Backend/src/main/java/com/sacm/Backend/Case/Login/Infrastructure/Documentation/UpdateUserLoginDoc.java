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
        summary = "Actualización de usuario administrativo",
        description = """
            Este endpoint permite actualizar los datos de login de un usuario administrativo.
            Campos actualizables: USUARIO, EMAIL, PASSWORD.
            """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Usuario actualizado correctamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                    {
                      "statusCode": 200,
                      "message": "User updated successfully!",
                      "errorCode": "200 OK",
                      "details": "Datos del usuario modificados correctamente",
                      "path": "Api/UpdateUserLogin"
                    }
                    """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Error en la actualización",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                    {
                      "statusCode": 400,
                      "message": "User update failed!",
                      "errorCode": "400 BAD_REQUEST",
                      "details": "Fallo en las validaciones del DTO de entrada",
                      "path": "Api/UpdateUserLogin"
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
                      "details": "No se encontró el usuario a actualizar",
                      "path": "Api/UpdateUserLogin"
                    }
                    """
                        )
                )
        )
})

public @interface UpdateUserLoginDoc {
}
