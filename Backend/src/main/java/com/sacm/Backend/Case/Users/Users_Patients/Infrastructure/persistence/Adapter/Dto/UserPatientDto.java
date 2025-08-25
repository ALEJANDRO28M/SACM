package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Adapter.Dto;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

import java.time.LocalDate;
import java.util.List;

public record UserPatientDto(
        Long id,
        String nombres,
        String apellidos,
        String email,
        String edad,
        String telefono,
        String cc,
        LocalDate fecha_Nacimiento,
        String genero,
      /*  HistorialMedico doctor,*/
        List<Citas> citas
) {

}
