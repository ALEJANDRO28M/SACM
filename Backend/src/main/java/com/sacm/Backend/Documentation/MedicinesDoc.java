package com.sacm.Backend.Documentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

//Documented indica que esta clase es una documentacion
@Documented
//TARGET-OBJETIVO: ESTO SIGNIFIA QUE ESTA ANOTACION NOS PERMITE USAR ESTA DOCUMENTACION
// SOLAMANENTE A METODOS
// EXISTEN VARIOS TIPOS DE USABILIDAD : METHOD, TYPE(CLASES,INTERFACES,ENUMS),
// FIELD (ATRIBUTOS), PARAMETER (PARAMETROS DE METODOS), CONSTRUCTOR (CONSTRUCTORES)

@Target(ElementType.METHOD)

// RETENCION = RETENTION  -  RETENTIONPOLICY = POLITCA DE RETENCION  -  RUNTIME = TIEMPO DE EJECUCION
@Retention(RetentionPolicy.RUNTIME)

@Operation( //SUMMARY = RESUMEN
        summary = "Obtener lista de medicamentos",
        description = """
        
        Este endpoint devuelve la lista completa de medicamentos disponibles en la base de datos.
        No requiere parámetros. Utilizado principalmente por personal médico y administrativo para
        consultar el inventario de medicinas.
        
        """
)

@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Lista obtenida correctamente.",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                                        {
                                        "statusCode": 200,
                                        "message": "Respuesta exitosa",
                                        "errorCode": "200 OK",
                                        "details": "Flujo procesado correctamente",
                                        "path": "/contact/support/request/{id}"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                                        {
                                        "statusCode": 400,
                                        "message": "Respuesta exitosa",
                                        "errorCode": "BAD_REQUEST",
                                        "details": "com.example.demo.exception.BadRequestException: ❌",
                                        "path": "/contact/support/request/{id}"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                example = """
                                        {
                                        "statusCode": 500,
                                        "message": "Ocurrio un error inesperado en el servidor",
                                        "errorCode": "500 INTERNAL SERVER",
                                        "details": "Se produjo un error inesperado",
                                        "path": "/contact/support/request/{id}"
                                        }
                                        """
                        )
                )
        )

}
)


public @interface MedicinesDoc {
}
