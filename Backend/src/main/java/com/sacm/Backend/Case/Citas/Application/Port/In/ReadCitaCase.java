package com.sacm.Backend.Case.Citas.Application.Port.In;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

import java.util.List;

public interface ReadCitaCase {
    Citas findByIdCita(Long id);
    List<Citas> findAllCitas();
   }
