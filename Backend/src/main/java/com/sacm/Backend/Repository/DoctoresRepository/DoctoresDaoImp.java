package com.sacm.Backend.Repository.DoctoresRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sacm.Backend.Models.Doctores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctoresDaoImp implements DoctoresDao {

        @PersistenceContext
    EntityManager entityManager;
    // Consulta JPQL para obtener los pacientes.
    private String query;


    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////LISTAR DOCTORES//////////////////////////////
    ////////////////////////////////////////////////////////////////////////
   
    @Override
    public List<Doctores> viewDoctores() {
     query = "FROM Doctores";
     return  entityManager.createQuery(query,Doctores.class).getResultList();
    }
}
