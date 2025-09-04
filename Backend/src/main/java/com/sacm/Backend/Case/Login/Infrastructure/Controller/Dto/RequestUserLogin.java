package com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto;

public record RequestUserLogin(
        Long id,
        String usuario,
        String password,
        String correo
) {
}
