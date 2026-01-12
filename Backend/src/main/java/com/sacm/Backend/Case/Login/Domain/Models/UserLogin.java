package com.sacm.Backend.Case.Login.Domain.Models;

import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;

public record UserLogin(
        Long id,
        String name,
        String password,
        String email,
        String role,//
        MedicEntity doctor
        ) {
}
