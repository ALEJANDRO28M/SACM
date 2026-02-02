package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;

import java.util.List;

public interface FindAllUserCase {
    List<UserLogin> findAll();
}
