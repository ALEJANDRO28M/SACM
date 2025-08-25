package com.sacm.Backend.Case.Users.Doctors.Application.Service;

import com.sacm.Backend.Case.Users.Doctors.Application.Port.In.CreateMedicUserCase;
import com.sacm.Backend.Case.Users.Doctors.Application.Port.In.DeleteMedicUserCase;
import com.sacm.Backend.Case.Users.Doctors.Application.Port.In.ReadMedicUserCase;
import com.sacm.Backend.Case.Users.Doctors.Application.Port.In.UpdateMedicUserCase;
import com.sacm.Backend.Case.Users.Doctors.Application.Port.Out.MedicRepositoryOutPort;
import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService
        implements CreateMedicUserCase,
        DeleteMedicUserCase,
        ReadMedicUserCase,
        UpdateMedicUserCase {

    MedicRepositoryOutPort outPort;

    public MedicService(MedicRepositoryOutPort outPort) {
        this.outPort = outPort;
    }

    @Override
    public Medico create(Medico medico) {
        return outPort.createMedico(medico);
    }

    @Override
    public Boolean deleteMedicUser(Long id) {
        return outPort.deleteMedico(id);
    }

    @Override
    public List<Medico> findAllMedico() {
        return outPort.findAllMedico();
    }

    @Override
    public Medico findMedicoById(Long id) {
        return outPort.findMedicoById(id);
    }

    @Override
    public Medico updateMedic(Medico medico) {
        return outPort.updateMedico(medico);
    }
}
