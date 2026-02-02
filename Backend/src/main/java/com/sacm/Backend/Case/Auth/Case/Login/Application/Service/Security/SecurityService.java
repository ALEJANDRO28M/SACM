package com.sacm.Backend.Case.Auth.Case.Login.Application.Service.Security;

import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.SecurityPasswordCase;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.SecurityPasswordOutPort;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements SecurityPasswordCase {


    SecurityPasswordOutPort security;

    public SecurityService(SecurityPasswordOutPort security) {
        this.security = security;
    }

    @Override
    public String encode(String rawPassword) {
        return security.encode(rawPassword);
    }

    @Override
    public Boolean matches(String rawPassword, String encodedPassword) {
        return security.matches(rawPassword, encodedPassword);
    }
}
