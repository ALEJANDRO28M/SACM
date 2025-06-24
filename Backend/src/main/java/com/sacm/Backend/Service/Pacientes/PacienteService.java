package com.sacm.Backend.Service.Pacientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sacm.Backend.Models.User_Of_Patients;

@Service
public class PacienteService {

    @Autowired
    PacienteDao dao;

    public List<User_Of_Patients> pacientes(){
        return dao.viewPacientes();
    }

        public void eliminarPaciente(int id) {
        // Llama al método del DAO para eliminar al paciente con el ID proporcionado
        dao.deletePaciente(id);
    }
        public User_Of_Patients pacienteId(Integer id){
            return dao.pacienteId(id);
        }
}
