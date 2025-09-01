package com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataLogin extends JpaRepository<UserLoginEntity,Long> {
}
