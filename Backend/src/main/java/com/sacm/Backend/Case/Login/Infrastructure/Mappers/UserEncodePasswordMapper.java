package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;

/**
 * Mapper encargado de transformar un DTO {@link RequestUserLogin}
 * en un modelo de dominio {@link UserLogin}, previo a la codificación de la contraseña.
 *
 * Este mapper puede utilizarse antes de aplicar lógica de encriptación en la capa de aplicación.
 */
public class UserEncodePasswordMapper {

    /**
     * Convierte un objeto {@link RequestUserLogin} en una instancia de {@link UserLogin}.
     *
     * @param request DTO recibido desde el controlador
     * @return modelo de dominio con los datos del usuario
     */
    public static UserLogin toDomain(RequestUserLogin request) {
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
