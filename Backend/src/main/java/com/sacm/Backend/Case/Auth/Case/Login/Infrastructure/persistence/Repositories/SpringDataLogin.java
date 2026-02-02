package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  SpringDataLogin extends JpaRepository<UserLoginEntity,Long> {
    UserLoginEntity findByUser(String user);
}

