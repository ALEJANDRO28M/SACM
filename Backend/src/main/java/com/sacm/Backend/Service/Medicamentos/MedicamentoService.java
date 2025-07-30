package com.sacm.Backend.Service.Medicamentos;

import java.io.IOException;
import java.util.List;

import com.sacm.Backend.Repository.MedicamentosRepository.MedicamentosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.Medicamentos;

@Service
public class MedicamentoService {
    
    @Autowired
    MedicamentosDao dao;

        public List<Medicamentos> showListMedicines() {return dao.showDataListMedicine();}
}
