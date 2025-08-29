package com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities.MedicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMedicalRepository extends JpaRepository<MedicalEntity, Long> {
}
