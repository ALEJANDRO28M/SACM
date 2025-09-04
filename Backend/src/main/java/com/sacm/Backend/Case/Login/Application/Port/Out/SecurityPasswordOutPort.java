package com.sacm.Backend.Case.Login.Application.Port.Out;

import org.springframework.stereotype.Repository;

@Repository
public interface SecurityPasswordOutPort {

    //ENCODE = CODIFICAR

    String encode (String rawPassword);
    Boolean matches(String rawPassword, String encodedPassword);
}
