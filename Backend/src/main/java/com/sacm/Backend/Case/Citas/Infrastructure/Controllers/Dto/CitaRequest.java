package com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto;

import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.User_Of_Patients;

public record CitaRequest(
        long id,
        String fecha,
        String motivo,
        HistorialMedico historialMedico,
        User_Of_Patients user
) {

}
