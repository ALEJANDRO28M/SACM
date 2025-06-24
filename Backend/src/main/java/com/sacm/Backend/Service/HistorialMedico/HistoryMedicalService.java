package com.sacm.Backend.Service.HistorialMedico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.HistorialMedico;

@Service
public class HistoryMedicalService {

    @Autowired
       HistoryMedicalDao dao;

        public List<HistorialMedico> showHistoryService() {
        return dao.historyMedicoAll();
    }
}
