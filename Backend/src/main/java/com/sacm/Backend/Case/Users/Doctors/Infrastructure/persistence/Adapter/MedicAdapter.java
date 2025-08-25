package com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Users.Doctors.Application.Port.Out.MedicRepositoryOutPort;
import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.MedicMapper;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Repositories.SpringDataMedicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicAdapter implements MedicRepositoryOutPort {

    SpringDataMedicRepository crud;

    public MedicAdapter(SpringDataMedicRepository crud) {
        this.crud = crud;
    }

    @Override
    public Medico createMedico(Medico medico) {
        MedicEntity save =  crud.save(MedicMapper.toEntity(medico));
        return MedicMapper.toDomain(save);
    }

    @Override
    public Medico updateMedico(Medico medico) {
        MedicEntity save =  crud.save(MedicMapper.toEntity(medico));
        return MedicMapper.toDomain(save);
    }

    @Override
    public Boolean deleteMedico(Long id) {
        if (crud.existsById(id)) {
            crud.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Medico> findAllMedico() {
        List<MedicEntity> save = crud.findAll();
        return MedicMapper.toDomainList(save);
    }

    @Override
    public Medico findMedicoById(Long id) {
       return crud.findById(id).map(MedicMapper::toDomain).orElseThrow(() -> new RuntimeException("Medico Not Found"));
    }
}
