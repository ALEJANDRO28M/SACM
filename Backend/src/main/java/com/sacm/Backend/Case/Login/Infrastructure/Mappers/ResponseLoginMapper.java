package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;

import java.util.List;

/**
 * Mapper encargado de transformar modelos de dominio {@link UserLogin}
 * en objetos de respuesta {@link ResponseUserLogin} utilizados en la capa de presentación.
 */
public class ResponseLoginMapper {

    /**
     * Convierte una lista de objetos {@link UserLogin} en una lista de {@link ResponseUserLogin}.
     *
     * @param listUser lista de usuarios del dominio
     * @return lista de DTOs para respuesta HTTP
     */
    public static List<ResponseUserLogin> toResponse(List<UserLogin> listUser){
        return listUser.stream().map(user -> new ResponseUserLogin(
                user.id(),
                user.name(),
                user.password(),
                user.email()
        )).toList();
    }

    /**
     * Convierte un objeto {@link UserLogin} en un {@link ResponseUserLogin}.
     *
     * @param request usuario del dominio
     * @return DTO para respuesta HTTP
     */
    public static ResponseUserLogin toResponse(UserLogin request) {
        return new ResponseUserLogin(
                request.id(),
                request.name(),
                request.password(),
                request.email()
        );
    }
}
