package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Citas.Application.Port.Out.CitaRepository_OutPort;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitasMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Repositories.SpringDateCitasRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CitaAdapter implements CitaRepository_OutPort {


    private final SpringDateCitasRepository springDateCitasRepository;

    public CitaAdapter(SpringDateCitasRepository springDateCitasRepository) {
        this.springDateCitasRepository = springDateCitasRepository;
    }

    @Override
    public Citas create(Citas citas) {
        CitasEntitys citasEntity = CitasMapper.toEntity(citas);
        CitasEntitys savedEntity =  springDateCitasRepository.save(citasEntity);
        return CitasMapper.toDomain(savedEntity);
    }

    @Override
    public Boolean delete(Long id) {
        if (springDateCitasRepository.existsById(id)) {
            springDateCitasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Citas update(Citas citas) {

        CitasEntitys savedUpdate = CitasMapper.toEntity(citas);
        CitasEntitys responseUpdate = springDateCitasRepository.save(savedUpdate);
        return CitasMapper.toDomain(responseUpdate);

    }

    @Override
    public Citas findById(Long id) {
        return  springDateCitasRepository.findById(id)
                .map(CitasMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Citas no encontrada"));

    }

    @Override
    public List<Citas> findAll() {
       final List<CitasEntitys> savedEntity  =  springDateCitasRepository.findAll();
       return CitasMapper.toListCitas(savedEntity);
    }
}
