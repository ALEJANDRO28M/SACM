package com.sacm.Backend.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sacm.Backend.Models.Citas;
import com.sacm.Backend.Models.Doctores;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.Medicamentos;
import com.sacm.Backend.Models.ModelUserLogin;
import com.sacm.Backend.Models.User_Of_Patients;

import jakarta.persistence.EntityManager;
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

    ///////////////// INYECCIÓN DE DEPENDENCIAS /////////////////////

    // EntityManager se utiliza para manejar las operaciones de persistencia en la base de datos.
    @PersistenceContext
    private EntityManager entityManager;

    // Consulta JPQL para obtener los pacientes.
    private String query;

    ///////////////// GESTIÓN DE LOS PACIENTES /////////////////////

    /**
     * Obtiene la lista de todos los pacientes desde la base de datos.
     *
     * @return Una lista de objetos {@link User_Of_Patients} que representa
     * todos los pacientes.
     */
    @SuppressWarnings("unchecked") // Suprime advertencias de tipo no verificado en el uso de generics.
    @Override
    public List<User_Of_Patients> MostrarUsers() {
        // Define la consulta JPQL para seleccionar todos los pacientes.
        query = "FROM User_Of_Patients";
        // Ejecuta la consulta y devuelve el resultado como una lista de objetos User_Of_Patients.
        return entityManager.createQuery(query).getResultList();
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
        // Consulta JPQL corregida, usando parámetros
        query = "SELECT COUNT(*) FROM ModelUserLogin u WHERE u.usuario = :usuario AND u.password = :password";

        Long count = (Long) entityManager.createQuery(query)
                .setParameter("usuario", usuario)
                .setParameter("password", password)
                .getSingleResult();

        return count > 0;
        // Retorna true si existe al menos un usuario con las credenciales dadas
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

        query = "INSERT INTO `userlogin` (`id`, `usuario`, `password`) VALUES (NULL, :usuario , :password)";

        // Crear la consulta y establecer los parámetros
        Query peticion = entityManager.createNativeQuery(query);
        peticion.setParameter("usuario", modelUserLogin.getUsuario());
        peticion.setParameter("password", modelUserLogin.getPassword());

        // Ejecutar la consulta de inserción
        peticion.executeUpdate();
    }

    ///////////////// GESTIÓN DE CITAS /////////////////////

    @Override
    public List<Citas> viewCitas() {
         query = "FROM Citas";
         return entityManager.createQuery(query,Citas.class).getResultList();
     
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showDataListMedicine'");
    }
}
