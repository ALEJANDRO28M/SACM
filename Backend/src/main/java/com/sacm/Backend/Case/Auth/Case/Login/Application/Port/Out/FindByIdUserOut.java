package com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out;

import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;

public interface FindByIdUserOut {
    UserLogin findById(Long id);
}
