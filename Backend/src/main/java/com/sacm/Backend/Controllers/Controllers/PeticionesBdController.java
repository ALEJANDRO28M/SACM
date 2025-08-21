package com.sacm.Backend.Controllers.Controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.sacm.Backend.Documentation.MedicinesDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // ✅ Para usar el tipo Date
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Models.Citas;
import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.Medicamentos;
import com.sacm.Backend.Models.ModelCode;
import com.sacm.Backend.Models.ModelUserLogin;
import com.sacm.Backend.Models.User_Of_Patients;
import com.sacm.Backend.Service.Citas.ACitaService;
import com.sacm.Backend.Service.Doctores.DoctoresServices;
import com.sacm.Backend.Service.HistorialMedico.HistoryMedicalService;
import com.sacm.Backend.Service.Medicamentos.MedicamentoService;
import com.sacm.Backend.Service.Pacientes.PacienteService;
import com.sacm.Backend.Service.UserLogin.UsuarioServiceLogin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class PeticionesBdController {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////CONTROLLER LISTA MEDICAMENTOS/////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    MedicamentoService medi;

    @GetMapping("/Medicines")
    @MedicinesDoc
    public List<Medicamentos> showListMedicines() {
        return medi.showListMedicines();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////CONTROLLER LISTA HISTORIAL MEDICO/////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Autowired
    HistoryMedicalService historyService;

    @GetMapping("/HistoryDoctor")
    public List<HistorialMedico> showHistory() {
        return historyService.showHistoryService();
    }
        
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////CONTROLLER LISTA DE PACIENTES/////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Autowired
    DoctoresServices doctoresServices;
    
    @GetMapping("/DataDoctor")
    public List<Doctores> listDoctoresController() {
     return doctoresServices.viewDoctoresService();
    }
    

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////GESTION DE LOS PACIENTES/////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    PacienteService servicePaciente;
    /**
     * Obtiene la lista de todos los pacientes.
     * 
     * @return Una lista de objetos User_Of_Patients.
     */
    @GetMapping("/ListPacients")
    public List<User_Of_Patients> pacientes() {
        // Llama al método del DAO para obtener la lista de pacientes
        return servicePaciente.pacientes();
    }

    /**
     * Elimina un paciente basado en el ID proporcionado.
     *
     * @param id El ID del paciente a eliminar.
     */
    @DeleteMapping("DeleteUserPacient/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        // Llama al método del DAO para eliminar al paciente con el ID proporcionado
      servicePaciente.eliminarPaciente(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////GESTION DE LAS CITAS/////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   /* @Autowired
    CitaService citaS;

    @GetMapping("/CitasPacientes")
    public List<Citas> viewCitas() {
        return citaS.viewCitas();
    } */

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////GESTION DE LAS CITAS DE LOS PACIENTES///////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    UsuarioServiceLogin serviceLogin;

    ////////////////////////////////METODO PARA REGISTRAR PACIENTES USERLOGIN///////////////////////////////////
    /// 
    @PostMapping("/Registrar")
    public void Registro(@RequestBody ModelUserLogin modelUserLogin) {
        serviceLogin.registrarUserLogin(modelUserLogin);
    }
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    ///////////////////////////////METODO PARA MOSTRAR LISTA DE PACIENTES USERLOGIN///////////////////////////////////
    /// 
    @GetMapping("/Data")
    public List<ModelUserLogin> dataLoginUser() {
        return serviceLogin.mostrarListaUsuariosLogin();
    }
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////METODO PARA ELIMINAR PACIENTE USERLOGIN ID///////////////////////////////////
    /// 
    /**
     * Elimina un paciente basado en el ID proporcionado.
     *
     * @param id El ID del paciente a eliminar.
     */
    @DeleteMapping("/DeleteUserLogin/{id}")
    public void deleteUserLogin(@PathVariable int id) {
        serviceLogin.deleteUserLogin(id);
    }
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////    


    ///////////////////////////////METODO PARA VALIDAR INICIO DE SESION///////////////////////////////////
    ///     
    @GetMapping("/validarInicio/{usuario}/{password}")
    public boolean validar(@PathVariable String usuario, @PathVariable String password) {                                        
        boolean valida = serviceLogin.validarInicioSesion(usuario, password);
        return valida;                      
    }
    ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////    


    @PostMapping("/cerrarSesion")
    public ResponseEntity<String> cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Sesión cerrada correctamente");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////RECOVER OF PASSWObvRD///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    RecoverController recoverController;

    @Autowired
    CodeInsert codeInsert;

    @GetMapping("/GeneratedPasswordRecover")
    public ResponseEntity<?> generatedpassword() {
        //GENERACION DE CODIGO DE RECUPERACION
        String code = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        //SETEAMOS EL VALOR DEL MODEL
        ModelCode modelCode = new ModelCode();
        
        //CREAMOS EL VALOR EN LA BD CON EL METODO SAVE DE CRUDREPOSITORY

// Obtener la fecha y hora actual del sistema
LocalDateTime ahora = LocalDateTime.now();

// Sumar 10 minutos a la hora actual
LocalDateTime expiracion = ahora.plusMinutes(1);

// Convertir el LocalDateTime a java.util.Date
Date fechaExpiracion = Date.from(expiracion.atZone(ZoneId.systemDefault()).toInstant());


modelCode.setCode(code);
// Establecer la fecha de expiración
modelCode.setFechaExpiracion(fechaExpiracion); // ✅ ahora sí es del tipo correcto



// Guardar el modelo con el código y la fecha de expiración en la base de datos
codeInsert.save(modelCode);

        //RETORNAMOS EL VALOR
        HashMap<String, String> map = new HashMap();
        map.put("reCode", code);
        System.out.println(map);



        return ResponseEntity.ok(map);//DEVOLVEMOS EL CODIGO DE RECUPERACION

    }

    @GetMapping("/ValidCode")
    public ResponseEntity<?> coReci(@RequestParam String correo) {
        Optional<ModelUserLogin> rUser = recoverController.findByCorreo(correo);
        if (rUser.isPresent()) {
            // generatedpassword();
            Map<String, String> response = new HashMap<>();
            response.put("correo", rUser.get().getCorreo());
            return ResponseEntity.ok(response); // Ahora sí es un JSON válido

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////VALID RECOVER PASSWORD////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    @Autowired   
    codeVeryController codeVeryController;

   @GetMapping("/keyValidCode")
public ResponseEntity<?> reValueValid(@RequestParam String code){
    Optional<ModelCode> valid = codeVeryController.findByCode(code);
    HashMap<String, String> map = new HashMap<>();

    if (valid.isPresent()) {
        ModelCode modelCode = valid.get();
        Date fechaExpiracion = modelCode.getFechaExpiracion();
        System.out.println( "Fecha de expiracion:" + fechaExpiracion);
        Date ahora = new Date();

        if (fechaExpiracion.before(ahora)) {
            // ❌ Código expirado: eliminar de la base de datos
            codeInsert.delete(modelCode);
            return ResponseEntity.status(HttpStatus.GONE).body("El código ha expirado");
        }

        // ✅ Código válido
        map.put("keyValid", modelCode.getCode());
        System.out.println("validación exitosa " + map);
        return ResponseEntity.ok(map);
    }

    // ❌ Código no existe
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código no encontrado");
}

 

}
