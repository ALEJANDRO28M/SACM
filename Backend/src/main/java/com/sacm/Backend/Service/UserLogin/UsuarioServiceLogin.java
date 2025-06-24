package com.sacm.Backend.Service.UserLogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacm.Backend.Models.ModelUserLogin;

@Service
public class UsuarioServiceLogin {


    @Autowired
    private ServiceUserLogin dao; // DAO personalizado para acceso a datos

    ///////////////// REGISTRAR USUARIO DE INICIO DE SESION /////////////////////
    public void registrarUserLogin(ModelUserLogin modelUserLogin) {
        dao.registrarUserLogin(modelUserLogin);
    }
    /////////////////////////////////////////////////////////////////////////////
    ///
    ///
    ///////////////////////// LISTA DE USUARIOS LOGIN ///////////////////////////
    public List<ModelUserLogin> mostrarListaUsuariosLogin() {
        return dao.mostrarListaUsuariosLogin();
    }
    /////////////////////////////////////////////////////////////////////////////
    ///
    ///
    ///////////////////////// DELETE DE USUARIOS LOGIN ///////////////////////////
    public void deleteUserLogin(int id) {
        dao.deleteUserLogin(id);
    }
    /////////////////////////////////////////////////////////////////////////////
    ///
    ///
    ///////////////////////// VALIDAR USUARIO LOGIN ///////////////////////////
    public boolean validarInicioSesion(String usuario, String password) {
        return dao.validarInicioSesion(usuario, password);
    }
    /////////////////////////////////////////////////////////////////////////////
}
