package com.sacm.Backend.Controllers.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Dao.DaoSacm;
import com.sacm.Backend.Models.User_Of_Patients;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ApiData")
public class DataPeticionSingle {

    @Autowired
    DaoSacm daoSacm;

    Logger logger = LoggerFactory.getLogger(DataPeticionSingle.class);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////VISUALIZACION DE DATOS UNICOS, POR ID O USUARIO DEPENDIENDO EL CASO////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    //MOSTRAR UNICO PACIENTE POR CITA
    @GetMapping("/citPatientId/{id}")
    public User_Of_Patients  verPaciente_Cita(@PathVariable Integer id) {
 
        return daoSacm.pacienteId(id);
    }

}
