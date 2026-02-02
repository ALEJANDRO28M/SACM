package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataRole extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRole(String role);
}
