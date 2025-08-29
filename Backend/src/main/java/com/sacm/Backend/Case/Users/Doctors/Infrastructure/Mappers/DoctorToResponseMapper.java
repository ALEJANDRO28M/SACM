package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorResponse;

import java.util.List;

public class DoctorToResponseMapper {
    public static DoctorResponse medicoToDoctorResponse(Medico medico){
        return new DoctorResponse(
                medico.id(),
                medico.nombre(),
                medico.apellido(),
                medico.especialidad(),
                medico.telefono(),
                medico.email()
        );
    }
    public static List<DoctorResponse> medicoToListDoctor(List<Medico> medico){
      return medico.stream().map(medic -> new DoctorResponse(
               medic.id(),
               medic.nombre(),
               medic.apellido(),
               medic.especialidad(),
               medic.telefono(),
               medic.email()
       )).toList();
    }
}
