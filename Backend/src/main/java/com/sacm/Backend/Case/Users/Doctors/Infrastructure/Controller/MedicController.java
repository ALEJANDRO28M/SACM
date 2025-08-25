package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller;

import com.sacm.Backend.Case.Users.Doctors.Application.Service.MedicService;
import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class MedicController {

    @Autowired
    MedicService  medicService;

    @GetMapping("/DataDoctor")
    public List<Medico> findAllMedic() {
        return medicService.findAllMedico();
    }
}
