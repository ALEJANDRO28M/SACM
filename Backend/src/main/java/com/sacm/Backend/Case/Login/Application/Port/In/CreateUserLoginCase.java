package com.sacm.Backend.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;

public interface CreateUserLoginCase {
    UserLogin create(UserLogin user);
}
