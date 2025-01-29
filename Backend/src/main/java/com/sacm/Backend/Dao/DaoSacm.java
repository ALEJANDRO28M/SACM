package com.sacm.Backend.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.Citas;
import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.Medicamentos;
import com.sacm.Backend.Models.ModelUserLogin;
import com.sacm.Backend.Models.User_Of_Patients;

/**
 * Interfaz que define los métodos para interactuar con los datos de los pacientes.
 */
@Service
public interface DaoSacm {

    ////////////////////////////////////////////////////////////////
    ///////////////// GESTIÓN DE LOS PACIENTES /////////////////////
    ////////////////////////////////////////////////////////////////
    /**
     * Obtiene la lista de todos los pacientes.
     * 
     * @return Una lista de objetos {@link User_Of_Patients} que representa todos los pacientes.
     */
    public List<User_Of_Patients> MostrarUsers();
    
    /**
     * Elimina un paciente basado en su ID.
     * 
     * @param id El identificador del paciente que se desea eliminar.
     */
    public void deleteUserSacm(int id);
    
    ////////////////////////////////////////////////////////////////////////
    ///////////////// GESTIÓN DE LOS USUARIOS DE LOGIN /////////////////////
    ////////////////////////////////////////////////////////////////////////

    public List<ModelUserLogin> mostrarListaUsuariosLogin();

    public void deleteUserLogin(int id);

    public boolean validarInicioSesion(String usuario, String password);

    public void registrarUserLogin(ModelUserLogin modelUserLogin);

    ////////////////////////////////////////////////////////////////////////
    //////////////////GESTION DE CITAS DE LOS PACIENTES/////////////////////
    ////////////////////////////////////////////////////////////////////////
    
    public List<Citas> viewCitas();


    ////////////////////////////////////////////////////////////////////////
    //////////////////GESTION DE USUARIOS DE LOS MEDICOS////////////////////
    ////////////////////////////////////////////////////////////////////////
    
    public List<Doctores> viewDoctores();

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////BD HISTORIAL MEDICO ////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public List<HistorialMedico> showDataHistory();

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////BD MEDICAMENTOS /////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public List<Medicamentos> showDataListMedicine();

    public User_Of_Patients pacienteId(Integer id);

}
