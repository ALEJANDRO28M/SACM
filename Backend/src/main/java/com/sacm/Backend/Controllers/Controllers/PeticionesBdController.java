package com.sacm.Backend.Controllers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Dao.DaoSacm;
import com.sacm.Backend.Models.Citas;
import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.Medicamentos;
import com.sacm.Backend.Models.User_Of_Patients;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class PeticionesBdController {
    

    @Autowired
    DaoSacm daoSacm;

    @GetMapping("/DataDoctor")
    public List<Doctores> listDoctoresController() {
        return daoSacm.viewDoctores();
    }

    
    @GetMapping("/HistoryDoctor")
    public List<HistorialMedico> showHistory(){
        return daoSacm.showDataHistory();
    }

    @GetMapping("/Medicines")
    public List<Medicamentos> showListMedicines(){
        return daoSacm.showDataListMedicine();
    }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////GESTION DE LOS PACIENTES/////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Obtiene la lista de todos los pacientes.
     * 
     * @return Una lista de objetos User_Of_Patients.
     */
    @GetMapping("/ListPacients")
    public List<User_Of_Patients> pacientes() {
        // Llama al método del DAO para obtener la lista de pacientes
        return daoSacm.MostrarUsers();
    }

    /**
     * Elimina un paciente basado en el ID proporcionado.
     * 
     * @param id El ID del paciente a eliminar.
     */
    @DeleteMapping("DeleteUser/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        // Llama al método del DAO para eliminar al paciente con el ID proporcionado
        daoSacm.deleteUserSacm(id);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////GESTION DE LAS CITAS DE LOS PACIENTES///////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/CitasPacientes")
    public List<Citas> viewCitas(){
        
        return daoSacm.viewCitas();
    }
}
