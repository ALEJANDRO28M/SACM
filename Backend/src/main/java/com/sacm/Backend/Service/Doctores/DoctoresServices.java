package com.sacm.Backend.Service.Doctores;

import java.util.List;

import com.sacm.Backend.Repository.DoctoresRepository.DoctoresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.Doctores;

@Service
public class DoctoresServices {

    @Autowired
    DoctoresDao dao;

    public List<Doctores> viewDoctoresService() {
        return dao.viewDoctores();

    }
}
