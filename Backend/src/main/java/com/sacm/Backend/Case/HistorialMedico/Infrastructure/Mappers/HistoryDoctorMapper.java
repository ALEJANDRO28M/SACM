package com.sacm.Backend.Case.HistorialMedico.Infrastructure.Mappers;

import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;
import com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Entities.HistoryDoctorEntity;

import java.util.List;

public class HistoryDoctorMapper {
    public static List<HistoryDoctor> toDomain(List<HistoryDoctorEntity> entity) {
        return entity.stream().map(history -> new HistoryDoctor(
               history.getId(),
               history.getFecha(),
               history.getDiagnostico(),
               history.getTratamiento()
       )).toList();
    }
}
