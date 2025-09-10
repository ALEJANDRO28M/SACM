package com.sacm.Backend.Case.Login.Infrastructure.Mappers;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;

import java.util.List;

/**
 * Mapper encargado de transformar entre entidades de persistencia {@link UserLoginEntity}
 * y modelos de dominio {@link UserLogin}, dentro de la capa de infraestructura.
 */
public class UserLoginMapper {

    /**
     * Convierte una lista de entidades {@link UserLoginEntity} en una lista de modelos de dominio {@link UserLogin}.
     *
     * @param listLoginEntity lista de entidades provenientes de la base de datos
     * @return lista de modelos de dominio
     */
    public static List<UserLogin> toDomain(List<UserLoginEntity> listLoginEntity) {
        return listLoginEntity.stream().map(entity -> new UserLogin(
                entity.getId(),
                entity.getUser(),
                entity.getPassword(),
                entity.getEmail()
        )).toList();
    }

    /**
     * Convierte una entidad {@link UserLoginEntity} en un modelo de dominio {@link UserLogin}.
     *
     * @param entity entidad de persistencia
     * @return modelo de dominio correspondiente
     */
    public static UserLogin toDomain(UserLoginEntity entity) {
        return new UserLogin(
                entity.getId(),
                entity.getUser(),
                entity.getPassword(),
                entity.getEmail()
        );
    }

    /**
     * Convierte un modelo de dominio {@link UserLogin} en una entidad {@link UserLoginEntity},
     * utilizando una contraseña ya codificada.
     *
     * @param user modelo de dominio
     * @param encoded contraseña codificada (por ejemplo, con BCrypt)
     * @return entidad lista para ser persistida
     */
    public static UserLoginEntity toEntity(UserLogin user, String encoded) {
        return new UserLoginEntity(
                user.id(),
                user.user(),
                encoded,
                user.email()
        );
    }
}
