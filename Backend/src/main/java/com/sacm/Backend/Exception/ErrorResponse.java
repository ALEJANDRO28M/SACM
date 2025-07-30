package com.sacm.Backend.Exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Estructura estandar para respuestas de error")
public class ErrorResponse {
    @Schema(description = "Código de estado HTTP", example = "500")
    private int statusCode;

    @Schema(description = "Mensaje del error", example = "Error interno del servidor")
    private String message;

    @Schema(description = "Código de error específico", example = "INTERNAL_SERVER_ERROR")
    private String errorCode;

    @Schema(description = "Detalles técnicos sobre el error",
            example = "NullPointerException en línea 42")
    private String details;

    @Schema(description = "Ruta del endpoint donde ocurrió el error", example = "/static/register")
    private String path;

    /**
     * Constructs an ErrorResponse object, automatically setting the timestamp to the current time.
     *
     * @param statusCode HTTP status code (e.g. 400, 404, 500)
     * @param message    Human-readable error message
     * @param errorCode  Application-specific error code (e.g. "USER_NOT_FOUND")
     * @param details    Technical details about the error
     * @param path       URI path where the error occurred
     */

    public ErrorResponse(int statusCode, String message, String errorCode, String details, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.path = path;
    }

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
