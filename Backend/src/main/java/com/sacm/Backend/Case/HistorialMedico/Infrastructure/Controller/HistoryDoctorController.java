package com.sacm.Backend.Case.HistorialMedico.Infrastructure.Controller;

import com.sacm.Backend.Case.HistorialMedico.Application.Port.In.ReadHistoryDoctorCase;
import com.sacm.Backend.Case.HistorialMedico.Domain.Models.HistoryDoctor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class HistoryDoctorController {

    ReadHistoryDoctorCase readHistoryDoctorCase;

    public HistoryDoctorController(ReadHistoryDoctorCase readHistoryDoctorCase) {
        this.readHistoryDoctorCase = readHistoryDoctorCase;
    }

    @GetMapping("/HistoryDoctor")
    public List<HistoryDoctor> HistoryDoctorFindAll() {
       return readHistoryDoctorCase.findAllHistoryDoctors();
    }
}
