package com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;

public interface UpdateUserPatientCase {
    User updateUser(User user);
}
