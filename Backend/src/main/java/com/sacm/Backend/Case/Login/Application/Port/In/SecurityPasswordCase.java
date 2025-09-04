package com.sacm.Backend.Case.Login.Application.Port.In;

public interface SecurityPasswordCase {
    String encode (String rawPassword);
    Boolean matches(String rawPassword, String encodedPassword);
}
