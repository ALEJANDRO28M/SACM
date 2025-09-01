package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;

import java.util.List;

public class UserLoginMapper {

    public static List<UserLogin> toDomain(List<UserLoginEntity> listLoginEntity) {
        return listLoginEntity.stream().map(entity -> new UserLogin(
                entity.getId(),
                entity.getUser(),
                entity.getPassword(),
                entity.getEmail()
        )).toList();
    }

    public static UserLogin toDomain(UserLoginEntity entity) {
        return new UserLogin(
                entity.getId(),
                entity.getUser(),
                entity.getPassword(),
                entity.getEmail()
        );
    }

    public static UserLoginEntity toEntity(UserLogin user) {
        return new UserLoginEntity(
                user.id(),
                user.user(),
                user.password(),
                user.email()
        );
    }
}
