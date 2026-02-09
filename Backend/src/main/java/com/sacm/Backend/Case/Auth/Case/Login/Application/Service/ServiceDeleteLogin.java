package com.sacm.Backend.Case.Auth.Case.Login.Application.Service;

import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.DeleteUserLoginCase;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteLogin implements DeleteUserLoginCase {

    @Override
    public boolean deleteUserLogin(Long id) {
        return false;
    }
}
