package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;

import java.util.List;

public class ResponseLoginMapper {
    public static List<ResponseUserLogin> toResponse(List<UserLogin> listUser){
        return listUser.stream().map(user -> new ResponseUserLogin(
                user.id(),
                user.user(),
                user.password(),
                user.email()
        )).toList();
    }
    public static ResponseUserLogin toResponse(UserLogin request) {
        return new ResponseUserLogin(
                request.id(),
                request.user(),
                request.password(),
                request.email()
        );
    }
}
