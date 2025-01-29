package com.sacm.Backend.Dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sacm.Backend.Models.Citas;
import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.Medicamentos;
import com.sacm.Backend.Models.ModelUserLogin;
import com.sacm.Backend.Models.User_Of_Patients;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz DaoSacm para manejar las operaciones de base de
 * datos relacionadas con los pacientes utilizando JPA.
 */
@Repository
@Transactional
public class DaoSacmImp implements DaoSacm {



    private static final Logger logger = LoggerFactory.getLogger(DaoSacmImp.class);

    ///////////////// INYECCIÓN DE DEPENDENCIAS /////////////////////

    // EntityManager se utiliza para manejar las operaciones de persistencia en la base de datos.
    @PersistenceContext
    private EntityManager entityManager;

    // Consulta JPQL para obtener los pacientes.
    private String query;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    ///////////////// GESTIÓN DE LOS PACIENTES /////////////////////

    /**
     * Obtiene la lista de todos los pacientes desde la base de datos.
     *
     * @return Una lista de objetos {@link User_Of_Patients} que representa
     * todos los pacientes.
     */

     //TRAER TODOS LOS PACIENTES DE LA BASE DE DATOS
    @SuppressWarnings("unchecked") // Suprime advertencias de tipo no verificado en el uso de generics.
    @Override
    public List<User_Of_Patients> MostrarUsers() {
        // Define la consulta JPQL para seleccionar todos los pacientes.
        query = "FROM User_Of_Patients";
        // Ejecuta la consulta y devuelve el resultado como una lista de objetos User_Of_Patients.
        return entityManager.createQuery(query).getResultList();
    }

    //TRAER UN UNICO PACIENTE DE LA BASE DE DATOS 
    @Override
    public User_Of_Patients pacienteId(Integer id){
        query = "FROM User_Of_Patients u WHERE u.id = :id";
        User_Of_Patients paciente = (User_Of_Patients) entityManager.createQuery(query).setParameter("id",id).getSingleResult();
        return paciente;
    }

    /**
     * Elimina un paciente basado en su ID.
     *
     * @param id El identificador del paciente que se desea eliminar.
     */
    @Override
    public void deleteUserSacm(int id) {
        // Busca el paciente con el ID proporcionado.
        User_Of_Patients user = entityManager.find(User_Of_Patients.class, id);
        // Elimina el paciente encontrado.
        entityManager.remove(user);
    }

    ///////////////// GESTIÓN DE USUARIOS DE LOGIN /////////////////////

    @SuppressWarnings("unchecked")
    @Override
    public List<ModelUserLogin> mostrarListaUsuariosLogin() {
        // Define la consulta JPQL para seleccionar todos los pacientes.
        query = "FROM ModelUserLogin";
        // Ejecuta la consulta y devuelve el resultado como una lista de objetos User_Of_Patients.
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteUserLogin(int id) {
        // Busca el paciente con el ID proporcionado.
        ModelUserLogin user = entityManager.find(ModelUserLogin.class, id);
        // Elimina el paciente encontrado.
        entityManager.remove(user);
    }

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


    @Override
    public void registrarUserLogin(ModelUserLogin modelUserLogin) {

        /*
         *  Cuando uses parámetros en consultas nativas de SQL, 
         * no necesitas poner comillas alrededor de los valores 
         * :usuario y :password. Colocarlos entre comillas los convierte 
         * en literales de texto, lo cual evitará que el setParameter los 
         * reemplace correctamente.
         */

        query = "INSERT INTO `userlogin` ( `usuario`, `password`) VALUES (:usuario , :password)";

        // Crear la consulta y establecer los parámetros
        Query peticion = entityManager.createNativeQuery(query);
        peticion.setParameter("usuario", modelUserLogin.getUsuario());
        peticion.setParameter("password", modelUserLogin.getPassword());

        // Ejecutar la consulta de inserción
        peticion.executeUpdate();
    //   
    }

    ///////////////// GESTIÓN DE CITAS /////////////////////

    @Override
    public List<Citas> viewCitas() {
         query = "FROM Citas";
         List<Citas> listCitas = new ArrayList();
         listCitas = entityManager.createQuery(query,Citas.class).getResultList();
         
         return listCitas;
         
     
    }

    /////////////////GESTION DE USUARIO DE DOCTORES////////////

    @Override
    public List<Doctores> viewDoctores() {
     query = "FROM Doctores";
     return  entityManager.createQuery(query,Doctores.class).getResultList();

    }

    @Override
    public List<HistorialMedico> showDataHistory() {
    query = "FROM HistorialMedico";
      return entityManager.createQuery(query, HistorialMedico.class).getResultList();
    }

    @Override
    public List<Medicamentos> showDataListMedicine() {
        query= "FROM Medicamentos";
        return entityManager.createQuery(query, Medicamentos.class).getResultList();
    }


}
