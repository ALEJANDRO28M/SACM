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

    public static User toUser(UserEntity user) {
        return new User(
                user.getId(),
                user.getNombres(),
                user.getApellidos(),
                user.getEmail(),
                user.getEdad(),
                user.getTelefono(),
                user.getCc(),
                user.getFecha_De_Nacimiento(),
                user.getGenero(),
                user.getCitas()
        );
    }

    public static UserEntity toEntity(User user) {
        return new  UserEntity(
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

    public static UserEntity updateEntity(User user, UserEntity userEntity) {
      userEntity.setNombres(user.nombres());
      userEntity.setApellidos(user.apellidos());
      userEntity.setEmail(user.email());
      userEntity.setEdad(user.edad());
      userEntity.setTelefono(user.telefono());
      userEntity.setCc(user.cc());
      return userEntity;
    }
}
