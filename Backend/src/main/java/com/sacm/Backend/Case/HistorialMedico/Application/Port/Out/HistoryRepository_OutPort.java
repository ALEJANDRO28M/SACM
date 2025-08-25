package com.sacm.Backend.Case.HistorialMedico.Application.Port.Out;

import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;

import java.util.List;

public interface HistoryRepository_OutPort {
    List<HistoryDoctor> findAllHistoryDoctors();
}
