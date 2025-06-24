package com.sacm.Backend.Service.Doctores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.User_Of_Patients;

@Service
public class DoctoresServices {

    @Autowired
    DoctoresDao dao;

    public List<Doctores> viewDoctoresService() {
        return dao.viewDoctores();

    }
}
