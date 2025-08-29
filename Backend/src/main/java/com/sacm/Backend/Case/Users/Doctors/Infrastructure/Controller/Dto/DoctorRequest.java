package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto;

public record DoctorRequest(
        Long id,
        String nombre,
        String apellido,
        String especialidad,
        String telefono,
        String email
) {
}
