package com.sacm.Backend.Case.Citas.Domain.Models;

import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.User_Of_Patients;

import java.time.LocalDateTime;

public record Citas(
   long id,
   String fecha,
   String motivo,
   HistorialMedico historialMedico,
   User_Of_Patients user
) {}
