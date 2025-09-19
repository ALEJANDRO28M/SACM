package com.sacm.Backend.Case.Medicamentos.Application.Port.Out;


import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;

import java.util.List;

public interface MedicalRepositoryOutPort {

    Medicamentos create(Medicamentos medicine);
    List<Medicamentos> findAll();
    Medicamentos findById(Long id);
    Medicamentos update(Medicamentos medicine);
    boolean delete(Long id);




}
