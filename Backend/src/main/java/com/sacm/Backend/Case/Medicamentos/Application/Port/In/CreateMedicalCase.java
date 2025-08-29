package com.sacm.Backend.Case.Medicamentos.Application.Port.In;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;

public interface CreateMedicalCase {
 Medicamentos create(Medicamentos medicine);
}
