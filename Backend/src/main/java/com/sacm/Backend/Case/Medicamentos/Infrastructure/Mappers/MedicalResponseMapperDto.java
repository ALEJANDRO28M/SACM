package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalResponseDto;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;

import java.util.List;

public class MedicalResponseMapperDto {
    public static List<MedicalResponseDto> listMedicamentos(List<Medicamentos> medical) {
        return  medical.stream().map(entity -> new MedicalResponseDto(
                entity.id(),
                entity.nombre(),
                entity.descripcion(),
                entity.dosis(),
                entity.frecuencia()
        )).toList();
    }

    public static MedicalResponseDto toResponseDto(Medicamentos medicamento) {
        return new MedicalResponseDto(
                medicamento.id(),
                medicamento.nombre(),
                medicamento.descripcion(),
                medicamento.dosis(),
                medicamento.frecuencia()
        );
    }
}
