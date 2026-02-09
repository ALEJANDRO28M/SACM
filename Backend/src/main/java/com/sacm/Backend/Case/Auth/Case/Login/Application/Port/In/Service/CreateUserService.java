package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.CreateUserLoginCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.CreateUserLoginOut;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserLoginCase {

    private final CreateUserLoginOut createUserLoginOut;


    public CreateUserService(CreateUserLoginOut createUserLoginOut){
        this.createUserLoginOut = createUserLoginOut;
    }

    @Override
    public ResponseEntity<?> create(UserLogin user) {
        return createUserLoginOut.create(user);
    }
}
