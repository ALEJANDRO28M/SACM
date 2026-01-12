package com.sacm.Backend.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;

public interface CreateUserLoginCase {
    ResponseEntity<?> create(UserLogin user);
}
