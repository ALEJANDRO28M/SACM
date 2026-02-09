package com.sacm.Backend.Case.HistorialMedico.Application.Service;

import com.sacm.Backend.Case.HistorialMedico.Application.Port.In.ReadHistoryDoctorCase;
import com.sacm.Backend.Case.HistorialMedico.Application.Port.Out.HistoryRepository_OutPort;
import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryDoctorService implements ReadHistoryDoctorCase {

    HistoryRepository_OutPort repositoryOutPort;

    public HistoryDoctorService(HistoryRepository_OutPort repositoryOutPort) {
        this.repositoryOutPort = repositoryOutPort;
    }

    @Override
    public List<HistoryDoctor> findAllHistoryDoctors() {
        return repositoryOutPort.findAllHistoryDoctors();
    }
}
