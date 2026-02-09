package com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Entities.HistoryDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataHistoryDoctor extends JpaRepository<HistoryDoctorEntity,Long> {
}
