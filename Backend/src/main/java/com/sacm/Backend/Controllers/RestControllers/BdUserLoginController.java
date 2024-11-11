package com.sacm.Backend.Controllers.RestControllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Dao.DaoSacm;
import com.sacm.Backend.Models.ModelUserLogin;
@CrossOrigin(origins = "http://localhost:5173")  // Cambia el puerto si es necesario
@RestController
@RequestMapping("/api")
public class BdUserLoginController {

    @Autowired
    DaoSacm daoSacmImp;

@GetMapping("/Data")
public List<ModelUserLogin> dataLoginUser(){
  
    return daoSacmImp.mostrarListaUsuariosLogin(); 
}


    /**
     * Elimina un paciente basado en el ID proporcionado.
     * 
     * @param id El ID del paciente a eliminar.
     */
    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUserLogin(@PathVariable int id) {
        // Llama al método del DAO para eliminar al paciente con el ID proporcionado
        daoSacmImp.deleteUserLogin(id);
    }

    @GetMapping("/validarInicio/{usuario}/{password}")
    public boolean validar(@PathVariable String usuario, @PathVariable String password){
        System.out.println("usuario =  " + usuario + "password = " + password);
        boolean valida = daoSacmImp.validarInicioSesion(usuario, password);
        System.out.println(valida);
        return valida;
        
    }

    @PostMapping("/Registrar")
    public void Registro(@RequestBody ModelUserLogin modelUserLogin){
      daoSacmImp.registrarUserLogin(modelUserLogin);
    }
}
