package com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto;

public record RequestUserLogin(
        Long id,
        String user,
        String password,
        String email
) {
}
