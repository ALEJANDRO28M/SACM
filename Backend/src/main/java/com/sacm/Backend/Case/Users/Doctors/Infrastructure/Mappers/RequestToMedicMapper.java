package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorRequest;

public class RequestToMedicMapper {
    public static Medico toMedico(DoctorRequest doctorRequest){
        return new Medico(
                doctorRequest.id(),
                doctorRequest.nombre(),
                doctorRequest.apellido(),
                doctorRequest.especialidad(),
                doctorRequest.telefono(),
                doctorRequest.email()
        );
    }
}
