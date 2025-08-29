package com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Medicamentos.Application.Port.Out.MedicalRepositoryOutPort;
import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.MedicalMapper;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Repositories.SpringDataMedicalRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MedicalAdapter implements MedicalRepositoryOutPort {


    SpringDataMedicalRepository crud;

    public MedicalAdapter(SpringDataMedicalRepository crud) {
        this.crud = crud;
    }

    @Override
    public Medicamentos create(Medicamentos medicine) {
        MedicalEntity toEntity = MedicalMapper.toEntity(medicine);
        return MedicalMapper.toDomain(crud.save(toEntity));
    }

    @Override
    public List<Medicamentos> findAll() {
        List<MedicalEntity> medicEntity = crud.findAll();
        return MedicalMapper.listMedicamentos(medicEntity);
    }

    @Override
    public Medicamentos findById(Long id) {
        return crud.findById(id)
                .map(MedicalMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Medicament no found"));
    }

    @Override
    public Medicamentos update(Medicamentos medic) {
        MedicalEntity toEntity = MedicalMapper.toEntity(medic);
        return MedicalMapper.toDomain(crud.save(toEntity));
    }

    @Override
    public Boolean delete(Long id) {
        if (crud.existsById(id)){
            crud.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
