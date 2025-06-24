package com.sacm.Backend.Service.HistorialMedico;

import java.util.List;

import com.sacm.Backend.Models.HistorialMedico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class HistoryMedicalDaoImp implements HistoryMedicalDao{

        // EntityManager se utiliza para manejar las operaciones de persistencia en la base de datos.
    @PersistenceContext
    private EntityManager entityManager;

    // Consulta JPQL para obtener los pacientes.
    private String query;

    @Override
    public List<HistorialMedico> historyMedicoAll() {
    query = "FROM HistorialMedico";
      return entityManager.createQuery(query, HistorialMedico.class).getResultList();
    }

}
