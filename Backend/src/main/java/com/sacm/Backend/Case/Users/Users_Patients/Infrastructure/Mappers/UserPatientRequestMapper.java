package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Controller.Dto.UserPatientRequest;

public class UserPatientRequestMapper {
    public static User request(UserPatientRequest userPatientRequest) {
        return new User(
                userPatientRequest.id(),
                userPatientRequest.nombres(),
                userPatientRequest.apellidos(),
                userPatientRequest.email(),
                userPatientRequest.edad(),
                userPatientRequest.telefono(),
                userPatientRequest.cc(),
                userPatientRequest.fecha_Nacimiento(),
                userPatientRequest.genero(),
                userPatientRequest.citas()
        );
    }
}
