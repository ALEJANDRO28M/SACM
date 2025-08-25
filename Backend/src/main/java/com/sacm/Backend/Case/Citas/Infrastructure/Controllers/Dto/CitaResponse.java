package com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto;

/*import com.sacm.Backend.Models.User_Of_Patients;*/

public record CitaResponse(
        long id,
        String fecha,
        String motivo
/*        HistorialMedico historialMedico,
        User_Of_Patients user*/
) {
}
