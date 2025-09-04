package com.sacm.Backend.Case.Login.Infrastructure.Security;

import com.sacm.Backend.Case.Login.Application.Port.Out.SecurityPasswordOutPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class LoginEncodePasswordAdapter implements SecurityPasswordOutPort {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public Boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
