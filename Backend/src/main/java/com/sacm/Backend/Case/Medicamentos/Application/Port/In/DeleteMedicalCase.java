package com.sacm.Backend.Case.Medicamentos.Application.Port.In;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;

public interface DeleteMedicalCase {
    boolean delete(Long id);
}
