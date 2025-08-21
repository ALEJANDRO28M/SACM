package com.sacm.Backend.Case.Citas.Infrastructure.Mappers;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

public class CitaRequestMapper {
    public static Citas requestToCita(CitaRequest citaRequest) {
        return new Citas(
                citaRequest.id(),
                citaRequest.fecha(),
                citaRequest.motivo(),
                citaRequest.historialMedico(),
                citaRequest.user());
    }
}
