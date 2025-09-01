package com.sacm.Backend.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;

import java.util.List;

public interface UserLoginRepositoryOutPort {
    List<UserLogin> findAll();
    UserLogin findById(Long id);
    Boolean deleteById(Long id);
    UserLogin create(UserLogin user);
    UserLogin update(UserLogin user);
}
