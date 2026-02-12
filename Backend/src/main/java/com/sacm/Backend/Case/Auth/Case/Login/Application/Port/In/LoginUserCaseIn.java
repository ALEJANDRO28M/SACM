package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LoginUserCaseIn {
    Map<String,String> loginUser(UserLogin login);
}
