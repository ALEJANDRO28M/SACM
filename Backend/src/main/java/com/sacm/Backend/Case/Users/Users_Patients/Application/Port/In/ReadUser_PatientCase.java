package com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;

import java.util.List;

public interface ReadUser_PatientCase {
    List<User> findAll();
    User findById(Long id);
}
