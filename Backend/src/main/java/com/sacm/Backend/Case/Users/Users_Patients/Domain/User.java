package com.sacm.Backend.Case.Users.Users_Patients.Domain;

import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;

import java.time.LocalDate;
import java.util.List;

public record User(
        Long id,
        String nombres,
        String apellidos,
        String email,
        String edad,
        String telefono,
        String cc,
        LocalDate fecha_Nacimiento,
        String genero,
/*        HistorialMedico doctor,*/
        List<CitasEntitys> citas
) {
}
