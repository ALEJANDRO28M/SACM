package com.sacm.Backend.Case.Auth.Case.Register.Application.Port.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Register.Application.Port.In.RegisterInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements RegisterInterface {



    @Override
    public ResponseEntity<?> createNewUser(UserLogin user) {
        return null;
    }
}
