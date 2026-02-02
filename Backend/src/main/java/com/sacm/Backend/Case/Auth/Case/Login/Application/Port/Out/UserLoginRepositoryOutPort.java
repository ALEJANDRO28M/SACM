package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserLoginRepositoryOutPort {
    List<UserLogin> findAll();
    UserLogin findById(Long id);
    Boolean deleteById(Long id);
    ResponseEntity<?> create(UserLogin user);
    UserLogin update(UserLogin user);
    ResponseEntity<Map<String,String>> LoginUser(UserLogin login);
}
