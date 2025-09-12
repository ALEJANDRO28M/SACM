package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Controller.Dto.UserPatientResponse;

import java.util.List;

public class UserToUserResponseMapper {

    public static List<UserPatientResponse> toResponse(List<User> users){
        return users.stream().map(user -> new UserPatientResponse(
                user.id(),
                user.nombres(),
                user.apellidos(),
                user.email(),
                user.edad(),
                user.telefono(),
                user.cc(),
                user.fecha_Nacimiento(),
                user.genero(),
                user.citas()
        )).toList();
    }

    public static UserPatientResponse toResponse(User user){
        return new UserPatientResponse(
                user.id(),
                user.nombres(),
                user.apellidos(),
                user.email(),
                user.edad(),
                user.telefono(),
                user.cc(),
                user.fecha_Nacimiento(),
                user.genero(),
                user.citas()
        );
    }
}
