package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;

import java.util.List;

public class MedicMapper {

    public static MedicEntity toEntity(Medico medico) {
        return new MedicEntity(
          medico.id(),
                medico.nombre(),
                medico.apellido(),
                medico.especialidad(),
                medico.telefono(),
                medico.email()
        );
    }
    public static Medico toDomain(MedicEntity medicEntity) {
        return new Medico(
                medicEntity.getId(),
                medicEntity.getNombre(),
                medicEntity.getApellido(),
                medicEntity.getEspecialidad(),
                medicEntity.getTelefono(),
                medicEntity.getEmail()
        );
    }


    public static List<Medico> toDomainList(List<MedicEntity> medicEntity) {
       return medicEntity.stream().map(entity -> new
               Medico(
               entity.getId(),
               entity.getNombre(),
               entity.getApellido(),
               entity.getEspecialidad(),
               entity.getTelefono(),
               entity.getEmail()
       )).toList();
    }
}
