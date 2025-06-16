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

/**
 * Controlador que gestiona peticiones relacionadas con la visualización
 * de datos individuales del paciente, generalmente a través de su ID.
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ApiData")
public class DataPeticionSingle {

    @Autowired
    DaoSacm daoSacm; // DAO que gestiona la lógica de acceso a datos

    private Integer enviarId; // Variable temporal para almacenar el ID recibido

    Logger logger = LoggerFactory.getLogger(DataPeticionSingle.class);

    // ============================================================================
    // ======================== FUNCIONALIDAD DE VISUALIZACIÓN ====================
    // ======================== DE PACIENTES INDIVIDUALES =========================
    // ============================================================================

    /**
     * Método que recibe un ID por parámetro y lo guarda internamente.
     * No retorna ningún valor, simplemente prepara el ID para ser usado
     * en la siguiente petición.
     * 
     * @param id ID del paciente a consultar
     */
    @GetMapping("/citPatientId/{id}")
    public void verPaciente_Cita(@PathVariable Integer id) {
        enviarId = id;
    }

    /**
     * Retorna el paciente correspondiente al ID previamente recibido.
     * Este endpoint depende de que previamente se haya ejecutado `verPaciente_Cita`
     * para establecer el ID que se usará en la consulta.
     * 
     * @return Objeto `User_Of_Patients` con los datos del paciente
     */
    @GetMapping("/MostrarPaciente")
    public User_Of_Patients ver() {
        logger.info("EL ID RECIBIDO EN LA SOLICITUD ES: " + enviarId);
        User_Of_Patients trPaciente = daoSacm.pacienteId(enviarId);
        return trPaciente;
    }
}
