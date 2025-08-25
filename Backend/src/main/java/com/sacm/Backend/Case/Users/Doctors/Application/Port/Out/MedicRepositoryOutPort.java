package com.sacm.Backend.Case.Users.Doctors.Application.Port.Out;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;

import java.util.List;

public interface MedicRepositoryOutPort {

    Medico createMedico(Medico medico);
    Medico updateMedico(Medico medico);
    Boolean deleteMedico(Long id);
    List<Medico> findAllMedico();
    Medico findMedicoById(Long id);

}
