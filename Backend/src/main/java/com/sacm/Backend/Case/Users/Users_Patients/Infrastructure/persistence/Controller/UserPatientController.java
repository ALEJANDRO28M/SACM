package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Controller;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Service.UserPatient_Service;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class UserPatientController {

    @Autowired
    UserPatient_Service crud;

    @GetMapping("/Data")
    public List<User> dataLoginUser() {
        return crud.findAll() ;
    }
}
