package com.sacm.Backend.Service.HistorialMedico;

import java.util.List;

import com.sacm.Backend.Repository.HistorialMedicoRespository.HistoryMedicalDao;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.HistorialMedico;

@Service
public class HistoryMedicalService {

    
       HistoryMedicalDao dao;

        public List<HistorialMedico> showHistoryService() {
        return dao.historyMedicoAll();
    }
}
