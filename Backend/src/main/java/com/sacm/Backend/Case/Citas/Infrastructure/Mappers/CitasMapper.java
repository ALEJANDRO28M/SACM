package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;

import java.util.List;

public class CitasMapper {
    /*
    * Aqui estamos mapeando 2 clases entre si
    * FLUJO = De entidad a domain
    * De Domain a Entity
    * */

    public static CitasEntitys toEntity(Citas domain) {
        return new CitasEntitys(
                domain.id(),
                domain.fecha(),
                domain.motivo(),
                domain.historialMedico(),
                domain.user()
        );
    }

    public static Citas toDomain(CitasEntitys entity) {
        return new Citas(
                entity.getId(),
                entity.getFecha(),
                entity.getMotivo(),
                entity.getHistorialMedico(),
                entity.getUser_Of_Patients()
        );
    }

    public static List<Citas> toListCitas(List<CitasEntitys> entity) {
      return  entity.stream().map(citasEntitys -> new Citas(
                citasEntitys.getId(),
                citasEntitys.getFecha(),
                citasEntitys.getMotivo(),
                citasEntitys.getHistorialMedico(),
                citasEntitys.getUser_Of_Patients()
        )).toList();

    }
}
