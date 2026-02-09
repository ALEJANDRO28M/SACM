package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.UpdateUserLoginCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.UpdateUserLoginOut;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements UpdateUserLoginCase {

    private final UpdateUserLoginOut updateUserLoginOut;

    public UpdateUserService(UpdateUserLoginOut updateUserLoginOut) {
        this.updateUserLoginOut = updateUserLoginOut;
    }

    @Override
    public UserLogin update(UserLogin user) {
        return updateUserLoginOut.update(user);
    }
}
