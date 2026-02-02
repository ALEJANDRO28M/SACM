package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.FindByIdLoginCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.FindByIdUserOut;
import org.springframework.stereotype.Service;

@Service
public class FindByIdUserService implements FindByIdLoginCase {

    private final FindByIdUserOut findByIdUserOut;

    public FindByIdUserService(FindByIdUserOut findByIdUserOut ) {
        this.findByIdUserOut = findByIdUserOut;
    }

    @Override
    public UserLogin findById(Long id) {
        return findByIdUserOut.findById(id);
    }

}
