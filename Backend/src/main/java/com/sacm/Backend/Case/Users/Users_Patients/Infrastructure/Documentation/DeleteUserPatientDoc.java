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
        summary = "Eliminación de usuario",
        description = """
        Este endpoint permite eliminar un usuario administrativo de la base de datos
        mediante su identificador único.
        """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Usuario eliminado exitosamente",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                {
                  "statusCode": 200,
                  "message": "Usuario eliminado correctamente!",
                  "errorCode": "200 OK",
                  "details": "El usuario fue eliminado de la base de datos",
                  "path": "Api/DeleteUserLogin/{id}"
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
                  "message": "No se pudo eliminar el usuario!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "Usuario no encontrado o inexistente",
                  "path": "Api/DeleteUserLogin/{id}"
                }
                """
                        )
                )
        )
})
public @interface DeleteUserPatientDoc {
}
