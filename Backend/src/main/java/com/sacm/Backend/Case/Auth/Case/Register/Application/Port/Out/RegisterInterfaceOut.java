package com.sacm.Backend.Case.Auth.Case.Register.Application.Port.Out;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import org.springframework.http.ResponseEntity;

public interface RegisterInterfaceOut {
    ResponseEntity<?> registerUser(UserLogin user);
}
