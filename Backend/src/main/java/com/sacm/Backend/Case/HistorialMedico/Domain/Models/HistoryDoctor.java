package com.sacm.Backend.Case.HistorialMedico.Domain.Models;

public record HistoryDoctor(
   long id,
   String fecha,
   String diagnostico,
   String tratamiento
) {}
