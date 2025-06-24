package com.sacm.Backend.Service.Citas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sacm.Backend.Models.Citas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CitaDaoImp implements CitaDao{

    @PersistenceContext
    EntityManager entityManager;

    private String query;

    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////LISTAR CITAS PACIENTES/////////////////////////
    ////////////////////////////////////////////////////////////////////////    
    @Override
    public List<Citas> viewCitas() {
         query = "FROM Citas";
         List<Citas> listCitas = new ArrayList();
         listCitas = entityManager.createQuery(query,Citas.class).getResultList();
         return listCitas;
    }
    
}
