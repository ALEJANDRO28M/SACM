package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;

import java.util.List;


public class UserPatientMapper {

    public static List<User> toDomain(List<UserEntity> users) {
        return users.stream()
                .map(userPatient -> new User(
                        userPatient.getId(),
                        userPatient.getNombres(),
                        userPatient.getApellidos(),
                        userPatient.getEmail(),
                        userPatient.getEdad(),
                        userPatient.getTelefono(),
                        userPatient.getCc(),
                        userPatient.getFecha_De_Nacimiento(),
                        userPatient.getGenero(),
/*                        userPatient.getHistorialMedico(),*/
                        userPatient.getCitas()
                )).toList();
    }
}
