package com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.HistorialMedico.Application.Port.Out.HistoryRepository_OutPort;
import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;
import com.sacm.Backend.Case.HistorialMedico.Infrastructure.Mappers.HistoryDoctorMapper;
import com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Entities.HistoryDoctorEntity;
import com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Repositories.SpringDataHistoryDoctor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HistoryDoctorAdapter implements HistoryRepository_OutPort {

    SpringDataHistoryDoctor springDataHistoryDoctor;

    public HistoryDoctorAdapter(SpringDataHistoryDoctor springDataHistoryDoctor) {
        this.springDataHistoryDoctor = springDataHistoryDoctor;
    }

    @Override
    public List<HistoryDoctor> findAllHistoryDoctors() {
        List<HistoryDoctorEntity> findAll =  springDataHistoryDoctor.findAll();
        return HistoryDoctorMapper.toDomain(findAll);

    }
}
