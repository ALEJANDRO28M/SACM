package com.sacm.Backend.Case.Citas.Application.Port.Out;

import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

import java.util.List;

public interface CitaRepository_OutPort {

    Citas create(Citas citas);
    boolean delete(Long id);
    Citas update(Citas citas);
    Citas findById(Long id);
    List<Citas> findAll();

}
