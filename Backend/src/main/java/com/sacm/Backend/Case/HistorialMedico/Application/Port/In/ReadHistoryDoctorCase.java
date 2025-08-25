package com.sacm.Backend.Case.HistorialMedico.Application.Port.In;

import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;

import java.util.List;

public interface ReadHistoryDoctorCase {
 List<HistoryDoctor> findAllHistoryDoctors();
}
