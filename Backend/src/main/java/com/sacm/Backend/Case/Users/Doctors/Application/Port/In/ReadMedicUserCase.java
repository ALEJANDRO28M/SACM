package com.sacm.Backend.Case.Users.Doctors.Application.Port.In;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;

import java.util.List;

public interface ReadMedicUserCase {
    List<Medico> findAllMedico();
    Medico findMedicoById(Long id);
}
