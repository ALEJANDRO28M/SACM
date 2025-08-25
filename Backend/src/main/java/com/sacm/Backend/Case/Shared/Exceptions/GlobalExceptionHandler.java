package com.sacm.Backend.Case.Shared.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(BadRequestException.class)
public ResponseEntity<ErrorResponse> handlerBadRequestException(BadRequestException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "BAD_REQUEST",
                ex.toString(),
                request.getRequestURI()
        );
    return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorResponse> InternalServerError(Exception ex, HttpServletRequest request) {
    ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.getMessage(),
            "INTERNAL_SERVER_ERROR",
            ex.toString(),
            request.getRequestURI()
    );
    return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
}

}
