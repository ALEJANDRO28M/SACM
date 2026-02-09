package com.sacm.Backend.Common.Exception;

public class UserLoginInvalidException extends RuntimeException {
    public UserLoginInvalidException(String message) {
        super(message);
    }
}
