package com.sacm.Backend.Case.Users.Doctors.Domain.Models;

public record Medico(
        Long id,
        String nombre,
        String apellido,
        String especialidad,
        String telefono,
        String email
) {
}
