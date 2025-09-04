package com.sacm.Backend.Common.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorResponse(

        @Schema(description = "Código de estado HTTP", example = "500")
        int status,
        @Schema(description = "Mensaje del error", example = "Error interno del servidor")
        String message,
        @Schema(description = "Código de error específico", example = "INTERNAL_SERVER_ERROR")
        String errorCode,
        @Schema(description = "Detalles técnicos sobre el error",
                example = "NullPointerException en línea 42")
        String details,
        @Schema(description = "Ruta del endpoint donde ocurrió el error", example = "/static/register")
        String path

) {
}
