package com.sacm.Backend.Controllers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Dao.DaoSacm;
import com.sacm.Backend.Models.HistorialMedico;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/ApiHistory")
public class HistoryDoctorController {

    @Autowired
    DaoSacm daoSacm;

    @GetMapping("/HistoryDoctor")
    public List<HistorialMedico> showHistory(){
        return daoSacm.showDataHistory();
    }
}
