package com.sacm.Backend.Case.Login.Application.Port.In;

import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;

public interface UpdateUserLoginCase {
    UserLogin update(UserLogin user);
}
