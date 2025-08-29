package com.sacm.Backend.Case.Medicamentos.Application.Service;

import com.sacm.Backend.Case.Medicamentos.Application.Port.In.CreateMedicalCase;
import com.sacm.Backend.Case.Medicamentos.Application.Port.In.DeleteMedicalCase;
import com.sacm.Backend.Case.Medicamentos.Application.Port.In.ReadMedicalCase;
import com.sacm.Backend.Case.Medicamentos.Application.Port.In.UpdateMedicalCase;
import com.sacm.Backend.Case.Medicamentos.Application.Port.Out.MedicalRepositoryOutPort;
import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentService
        implements
        CreateMedicalCase,
        UpdateMedicalCase,
        DeleteMedicalCase,
        ReadMedicalCase {

    MedicalRepositoryOutPort crud;

    public MedicamentService(MedicalRepositoryOutPort crud) {
        this.crud = crud;
    }

    @Override
    public Medicamentos create(Medicamentos medicine) {
        return crud.create(medicine);
    }

    @Override
    public boolean delete(Long id) {
        return crud.delete(id);
    }

    @Override
    public List<Medicamentos> findAll() {
        return crud.findAll();
    }

    @Override
    public Medicamentos findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Medicamentos update(Medicamentos medicine) {
        return crud.update(medicine);
    }
}
