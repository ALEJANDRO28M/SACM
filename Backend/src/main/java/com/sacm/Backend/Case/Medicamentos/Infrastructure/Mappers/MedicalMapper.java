package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;

import java.util.List;

public class MedicalMapper {

    public static Medicamentos toDomain(MedicalEntity medicalEntity) {
        return new Medicamentos(
                medicalEntity.getId(),
                medicalEntity.getName(),
                medicalEntity.getDescription(),
                medicalEntity.getDose(),
                medicalEntity.getFrequency()
        );
    }
    public static MedicalEntity toEntity(Medicamentos medical) {
        return new MedicalEntity(
                medical.id(),
                medical.nombre(),
                medical.descripcion(),
                medical.dosis(),
                medical.frecuencia()
        );
    }

    public static List<Medicamentos> listMedicamentos(List<MedicalEntity> medicalEntity) {
      return  medicalEntity.stream().map(entity -> new Medicamentos(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDose(),
                entity.getFrequency()
        )).toList();
    }
}
