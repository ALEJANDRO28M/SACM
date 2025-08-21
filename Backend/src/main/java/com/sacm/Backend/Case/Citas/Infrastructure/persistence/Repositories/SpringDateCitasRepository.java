package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Repositories;


import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDateCitasRepository extends JpaRepository<CitasEntitys,Long> {
}
