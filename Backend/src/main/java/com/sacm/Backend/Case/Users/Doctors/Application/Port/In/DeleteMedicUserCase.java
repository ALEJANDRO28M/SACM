package com.sacm.Backend.Case.Users.Doctors.Application.Port.In;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;

public interface DeleteMedicUserCase {
    boolean deleteMedicUser(Long id);
}
