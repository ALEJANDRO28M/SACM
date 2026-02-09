package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.DeleteUserLoginCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.DeleteUserLoginOut;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService implements DeleteUserLoginCase {

    private final DeleteUserLoginOut deleteUserLoginOut;

    public DeleteUserService(DeleteUserLoginOut deleteUserLoginOut) {
        this.deleteUserLoginOut = deleteUserLoginOut;
    }

    @Override
    public boolean deleteUserLogin(Long id) {
        return deleteUserLoginOut.deleteUserLogin(id);
    }
}
