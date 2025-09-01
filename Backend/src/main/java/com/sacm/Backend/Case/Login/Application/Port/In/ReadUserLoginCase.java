package com.sacm.Backend.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;

import java.util.List;

public interface ReadUserLoginCase {

    List<UserLogin> findAll();
    UserLogin findById(Long id);

}
