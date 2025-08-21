package com.sacm.Backend.Service.Citas;

import java.util.List;

import com.sacm.Backend.Repository.CitaRepository.CitaDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sacm.Backend.Models.Citas;

@Service
public class ACitaService {

    @Autowired
    CitaDao dao;

        public List<Citas> viewCitas() {
        return dao.viewCitas();
    }

}
