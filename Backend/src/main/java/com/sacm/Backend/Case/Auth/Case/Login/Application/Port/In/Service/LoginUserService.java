package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.LoginUserCaseIn;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginUserService implements LoginUserCaseIn {

    private final UserLoginRepositoryOutPort  userLoginRepositoryOutPort;

    public LoginUserService(UserLoginRepositoryOutPort userLoginRepositoryOutPort) {
        this.userLoginRepositoryOutPort = userLoginRepositoryOutPort;
    }

    @Override
    public Map<String,String> loginUser(UserLogin login) {
        return userLoginRepositoryOutPort.LoginUser(login);
    }
}
