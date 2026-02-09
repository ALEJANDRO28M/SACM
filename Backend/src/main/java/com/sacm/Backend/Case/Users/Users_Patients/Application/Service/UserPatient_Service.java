package com.sacm.Backend.Case.Users.Users_Patients.Application.Service;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In.CreateUser_PatientCase;
import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In.DeleteUserPatientCase;
import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In.ReadUser_PatientCase;
import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In.UpdateUserPatientCase;
import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.Out.User_PatientRepositoryOutPort;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPatient_Service implements
        ReadUser_PatientCase,
        CreateUser_PatientCase,
        DeleteUserPatientCase,
        UpdateUserPatientCase {

    User_PatientRepositoryOutPort out;

    public UserPatient_Service(User_PatientRepositoryOutPort out) {
        this.out = out;
    }

    @Override
    public List<User> findAll() {
        return out.findAll();
    }

    @Override
    public User findById(Long id) {
        return out.findById(id);
    }

    @Override
    public User createUser(User user) {
        return out.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return out.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return out.update(user);
    }
}
