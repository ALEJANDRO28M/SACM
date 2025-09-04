package com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto;

public record SecurityDto(
        String rawPassword,
        String encodedPassword
) {
}
