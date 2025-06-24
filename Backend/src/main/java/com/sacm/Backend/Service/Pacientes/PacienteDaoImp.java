package com.sacm.Backend.Service.Pacientes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.sacm.Backend.Models.User_Of_Patients;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class PacienteDaoImp implements PacienteDao {

    @PersistenceContext
    EntityManager entityManager;
    // Consulta JPQL para obtener los pacientes.
    private String query;

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////LISTAR USUARIO PACIENTES/////////////////////////
    ////////////////////////////////////////////////////////////////////////

    @Override
    public List<User_Of_Patients> viewPacientes() {
       // Define la consulta JPQL para seleccionar todos los pacientes.
        query = "FROM User_Of_Patients";
        // Ejecuta la consulta y devuelve el resultado como una lista de objetos User_Of_Patients.
        return entityManager.createQuery(query).getResultList();
    }

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////DELETE PACIENTE ID/////////////////////////
    ////////////////////////////////////////////////////////////////////////

    @Override
    public void deletePaciente(int id) {
        // Busca el paciente con el ID proporcionado.
        User_Of_Patients user = entityManager.find(User_Of_Patients.class, id);
        // Elimina el paciente encontrado.
        entityManager.remove(user);
    }

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////TRAER UNICO PACIENTE ID/////////////////////////
    ////////////////////////////////////////////////////////////////////////

    @Override
    public User_Of_Patients pacienteId(Integer id) {
        query = "FROM User_Of_Patients u WHERE u.id = :id";
        User_Of_Patients paciente = (User_Of_Patients) entityManager.createQuery(query).setParameter("id",id).getSingleResult();
        return paciente;
    }

}
