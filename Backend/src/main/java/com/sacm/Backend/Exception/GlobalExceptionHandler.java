package com.sacm.Backend.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
//INDICA QUE ESTA CLASE SE ENCARGARA DE MANEJAR TODO TIPO DE
//EXCEPCIONES, COMO TAMBIEN TIENE SIERTAS FUNCIONALIDADES
//COMO VALIDACIONES, LOGS
@ControllerAdvice
public class GlobalExceptionHandler {
    
    public ResponseEntity<ErrorResponse> handleDataAccessException(
            DataAccessException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                "DataAccessException",
                ex.toString(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
