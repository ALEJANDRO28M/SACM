package com.sacm.Backend.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserLoginRepositoryOutPort {
    List<UserLogin> findAll();
    UserLogin findById(Long id);
    Boolean deleteById(Long id);
    UserLogin create(UserLogin user);
    UserLogin update(UserLogin user);
    Map<String,Object>LoginUser(UserLogin login);
}
