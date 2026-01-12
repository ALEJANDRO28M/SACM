package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;

/**
 * Mapper encargado de transformar un DTO de entrada (RequestUserLogin)
 * en un modelo de dominio (UserLogin) para su uso en la capa de aplicación.
 */
public class RequestLoginMapper {

    /**
     * Convierte un objeto RequestUserLogin en un modelo de dominio UserLogin.
     *
     * @param request DTO recibido desde el controlador
     * @return instancia de UserLogin con los datos del DTO
     */
    public static UserLogin toDomain(RequestUserLogin request) {
        if (request == null) {
            throw new IllegalArgumentException("El DTO de login no puede ser nulo");
        }

        return new UserLogin(
                request.id(),
                request.name(),
                request.password(),
                request.email(),
                request.role(),
                request.doctor()
        );
    }
}
