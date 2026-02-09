package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.FindAllUserCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.FindAllUserLoginOut;
import org.springframework.stereotype.Service;

import java.util.List;

//implements interface de FINDALLUSER
@Service
public class FindAllUsersService implements FindAllUserCase {

    private final FindAllUserLoginOut findAllUserLoginOut;

    public FindAllUsersService(FindAllUserLoginOut findAllUserLoginOut) {
        this.findAllUserLoginOut = findAllUserLoginOut;
    }

    @Override
    public List<UserLogin> findAll() {
        return findAllUserLoginOut.findAll();
    }
}
