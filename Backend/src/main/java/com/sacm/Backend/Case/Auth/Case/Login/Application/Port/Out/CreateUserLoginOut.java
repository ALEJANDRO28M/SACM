package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;

public interface CreateUserLoginOut {
    ResponseEntity<?> create(UserLogin user);
}
