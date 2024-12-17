package com.sacm.Backend.Controllers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Dao.DaoSacm;
import com.sacm.Backend.Models.Medicamentos;
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/ApiMedicines")
public class MedicinesController {

   @Autowired 
   DaoSacm daoSacm; 


    public List<Medicamentos> showListMedicines(){
        return daoSacm.showDataListMedicine();
    }
}
