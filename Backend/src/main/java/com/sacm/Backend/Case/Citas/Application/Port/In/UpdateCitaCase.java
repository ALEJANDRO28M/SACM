package com.sacm.Backend.Case.Citas.Application.Port.In;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

public interface UpdateCitaCase {
    Citas UpdateCita(Citas citas);
}
