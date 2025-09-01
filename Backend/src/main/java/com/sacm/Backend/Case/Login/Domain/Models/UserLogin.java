package com.sacm.Backend.Case.Login.Domain.Models;

public record UserLogin(
        Long id,
        String user,
        String password,
        String email
        ) {
}
