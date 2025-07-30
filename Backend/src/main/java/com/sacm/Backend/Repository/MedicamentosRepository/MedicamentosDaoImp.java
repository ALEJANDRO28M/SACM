package com.sacm.Backend.Repository.MedicamentosRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sacm.Backend.Models.Medicamentos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MedicamentosDaoImp implements MedicamentosDao {

    
    // EntityManager se utiliza para manejar las operaciones de persistencia en la base de datos.
    @PersistenceContext
    private EntityManager entityManager;

    // Consulta JPQL para obtener los pacientes.
    private String query;

    @Override
    public List<Medicamentos> showDataListMedicine() {
        query= "FROM Medicamentos";
        return entityManager.createQuery(query, Medicamentos.class).getResultList();
    }

}
