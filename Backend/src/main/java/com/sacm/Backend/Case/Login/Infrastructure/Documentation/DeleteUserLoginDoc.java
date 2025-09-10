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
        summary = "EliminarUsuario",
        description = """
                Elimina un usuario de la base de datos
                """
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = """
                        Operacion exitosa. Se elimina un usuario de la 
                        base de datos
                        """,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                  {
                  "statusCode": 200,
                  "message": "User Deleted!",
                  "errorCode": "200 OK",
                  "details": "Flujo procesado correctamente",
                  "path": "Api/DeleteUserLogin/{id}"
                  }
                  """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = """
                        La operacion fallo, el usuario no se creo
                        correctamente.
                  """,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                  {
                  "statusCode": 404,
                  "message": "Users brought correctly!",
                  "errorCode": "404 NOT_FOUND",
                  "details": "Usuario no encontrado o inexistente!",
                  "path": "Api/DeleteUserLogin/{id}"
                  }
                  """
                        )
                )
        )
})
public @interface DeleteUserLoginDoc {
}
