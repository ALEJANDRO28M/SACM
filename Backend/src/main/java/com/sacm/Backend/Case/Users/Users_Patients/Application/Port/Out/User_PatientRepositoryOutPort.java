package com.sacm.Backend.Case.Users.Users_Patients.Application.Port.Out;

import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;

import java.util.List;

public interface User_PatientRepositoryOutPort {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    boolean deleteById(Long id);
    User update(User user);
}
