package com.sacm.Backend.Service.UserLogin;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sacm.Backend.Models.ModelUserLogin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SerUserLoginImp implements ServiceUserLogin{

    @PersistenceContext
    EntityManager entityManager;

    // Consulta JPQL para obtener los pacientes.
    private String query;
    // CLASE PARA ENCRIPTAR CONTRASENIA
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////REGISTRAR USUARIO LOGIN/////////////////////////
    ////////////////////////////////////////////////////////////////////////

    @Override
    public void registrarUserLogin(ModelUserLogin modelUserLogin) {

        /*
         *  Cuando uses parámetros en consultas nativas de SQL, 
         * no necesitas poner comillas alrededor de los valores 
         * :usuario y :password. Colocarlos entre comillas los convierte 
         * en literales de texto, lo cual evitará que el setParameter los 
         * reemplace correctamente.
         */

        query = "INSERT INTO `userlogin` ( `usuario`, `password`, `correo` ) VALUES (:usuario , :password , :correo)";

        // Crear la consulta y establecer los parámetros
        Query peticion = entityManager.createNativeQuery(query);
        peticion.setParameter("usuario", modelUserLogin.getUsuario());
        peticion.setParameter("password", modelUserLogin.getPassword());
        peticion.setParameter("correo", modelUserLogin.getCorreo());

        // Ejecutar la consulta de inserción
        peticion.executeUpdate();
    //   
    }

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////LISTAR USUARIO LOGIN/////////////////////////
    ////////////////////////////////////////////////////////////////////////

    
    @SuppressWarnings("unchecked")
    @Override
    public List<ModelUserLogin> mostrarListaUsuariosLogin() {
        // Define la consulta JPQL para seleccionar todos los pacientes.
        query = "FROM ModelUserLogin";
        // Ejecuta la consulta y devuelve el resultado como una lista de objetos User_Of_Patients.
        return entityManager.createQuery(query).getResultList();
    }

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////DELETE USUARIO LOGIN/////////////////////////
    ////////////////////////////////////////////////////////////////////////    

    @Override
    public void deleteUserLogin(int id) {
        // Busca el paciente con el ID proporcionado.
        ModelUserLogin user = entityManager.find(ModelUserLogin.class, id);
        // Elimina el paciente encontrado.
        entityManager.remove(user);
    }

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////VALIDAR INICIO LOGIN/////////////////////////
    ////////////////////////////////////////////////////////////////////////    
    
    @Override
    public boolean validarInicioSesion(String usuario, String password) {
    try {
        // Usamos JPQL para buscar por el campo 'usuario'
        Query query = entityManager.createQuery("SELECT u FROM ModelUserLogin u WHERE u.usuario = :usuario");
        query.setParameter("usuario", usuario);

        // Intentamos obtener el usuario de la base de datos
        ModelUserLogin user = (ModelUserLogin) query.getSingleResult();

        // Validamos la contraseña con BCrypt
        return passwordEncoder.matches(password, user.getPassword());
        
    } catch (NoResultException e) {
        // Si no se encuentra el usuario, devuelve false
        return false;
    } catch (Exception e) {
        // Maneja cualquier otra excepción y muestra detalles en los logs
        e.printStackTrace();
        return false;
    }
    }
    

}
