package com.sacm.Backend.Case.Auth.Case.Register.Application.Port.In;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;

public interface RegisterInterface {
    ResponseEntity<?> createNewUser(UserLogin user);
}
