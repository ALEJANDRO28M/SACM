package com.sacm.Backend.Case.Citas.Application.Service;

import com.sacm.Backend.Case.Citas.Application.Port.In.CreateCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.DeleteCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.ReadCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.UpdateCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.Out.CitaRepository_OutPort;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService
        implements
        CreateCitaCase,
        DeleteCitaCase,
        ReadCitaCase,
        UpdateCitaCase {

    private final CitaRepository_OutPort citaRepository_outPort;

    public CitaService(CitaRepository_OutPort citaRepository_outPort) {
        this.citaRepository_outPort = citaRepository_outPort;
    }

    @Override
    public Citas CreateCita(Citas citas) {
        return citaRepository_outPort.create(citas);
    }

    @Override
    public Boolean DeleteCita(Long id) {
        return null;
    }

    @Override
    public Citas findByIdCita(Citas citas) {
        return null;
    }

    @Override
    public List<Citas> findAllCitas() {
        return citaRepository_outPort.findAll();
    }

    @Override
    public Citas UpdateCita(Citas citas) {
        return citaRepository_outPort.update(citas);
    }
}
