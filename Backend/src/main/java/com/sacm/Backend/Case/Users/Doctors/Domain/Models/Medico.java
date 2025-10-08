package com.sacm.Backend.Case.Users.Doctors.Domain.Models;

public record Medico(
        Long id,
        String nombre,
        String apellido,
        int edad,
        String especialidad,
        String telefono,
        String email,
        String description
) {
}
