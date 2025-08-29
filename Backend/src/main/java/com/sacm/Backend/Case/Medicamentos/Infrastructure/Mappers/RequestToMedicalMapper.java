package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalRequest;

public class RequestToMedicalMapper {
    public static Medicamentos toMedical (MedicalRequest request){
        return new Medicamentos(
                request.id(),
                request.nombre(),
                request.descripcion(),
                request.dosis(),
                request.frecuencia()
        );
    }
}
