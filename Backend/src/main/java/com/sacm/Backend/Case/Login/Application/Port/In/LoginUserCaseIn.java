package com.sacm.Backend.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;

import java.util.Map;

public interface LoginUserCaseIn {
    Map<String, Object> loginUser(UserLogin login);
}
