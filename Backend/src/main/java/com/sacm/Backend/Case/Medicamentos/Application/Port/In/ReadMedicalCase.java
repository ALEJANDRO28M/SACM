package com.sacm.Backend.Case.Medicamentos.Application.Port.In;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;

import java.util.List;

public interface ReadMedicalCase {
    List<Medicamentos> findAll();
    Medicamentos findById(Long id);
}
