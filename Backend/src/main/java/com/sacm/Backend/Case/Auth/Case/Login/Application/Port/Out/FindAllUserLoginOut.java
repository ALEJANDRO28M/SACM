package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;

import java.util.List;

public interface FindAllUserLoginOut {
    List<UserLogin> findAll();
}
