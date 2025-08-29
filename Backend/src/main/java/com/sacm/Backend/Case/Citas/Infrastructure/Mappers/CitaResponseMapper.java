package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;

import java.util.List;

public class CitaResponseMapper {

    public static List<CitaResponse> toListResponseDto(List<Citas> citas) {
        return citas.stream()
                .map(cita -> new CitaResponse(
                        cita.id(),
                        cita.fecha(),
                        cita.motivo()/*,
                        cita.historialMedico(),
                        cita.user()*/
                ))
                .toList();
    }
    //MAPEAR DE CITA A RESPONSEMAPPER

    public static CitaResponse citaToResponseDtoMapper(Citas cita) {
        return new CitaResponse(
                cita.id(),
                cita.fecha(),
                cita.motivo()
        );
    }
}
