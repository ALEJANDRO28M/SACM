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
        summary = "Traer todos lo datos de la BD de UserLogin",
        description = """
                Retorna una lista con los datos de todos los usuarios almacenados 
                en la base de datos, incluyendo ID, nombre de usuario, contraseña 
                y correo electronico.
                """
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = """
                        Respuesta exitosa. Se retorna una lista con todos los
                        datos de los usuarios registrados. 
                        """,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                  {
                  "statusCode": 200,
                  "message": "Users brought correctly!",
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
                description = "Los datos no fueron encontrados!",
                content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                        example = """
                        {
                        "statusCode": 500,
                        "message": "Error Persistence Content",
                        "errorCode": "500 Error",
                        "details": "Error inesperado al traer los datos ",
                        "path": "Api/findAllUserLogin"
                        }
                        """
                )
        )
        ),

})
public @interface FindAllUserLoginDoc {
}
