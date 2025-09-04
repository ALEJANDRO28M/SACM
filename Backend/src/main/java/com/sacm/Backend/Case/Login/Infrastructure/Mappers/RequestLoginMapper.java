package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;

public class RequestLoginMapper {
    public static UserLogin toDomain(RequestUserLogin request) {
        return new UserLogin(
                request.id(),
                request.usuario(),
                request.password(),
                request.correo()
        );
    }
}
