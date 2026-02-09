package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;

public interface FindByIdLoginCase {
    UserLogin findById(Long id);
}
