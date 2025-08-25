package com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMedicRepository extends JpaRepository<MedicEntity, Long> {
}
