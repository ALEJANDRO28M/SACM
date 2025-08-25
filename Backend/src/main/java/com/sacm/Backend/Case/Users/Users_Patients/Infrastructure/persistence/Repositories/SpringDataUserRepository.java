package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Integer> {
}
