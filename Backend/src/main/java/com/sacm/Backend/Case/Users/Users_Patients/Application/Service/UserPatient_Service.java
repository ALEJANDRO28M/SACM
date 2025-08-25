package com.sacm.Backend.Case.Users.Users_Patients.Application.Service;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.In.ReadUser_PatientCase;
import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.Out.User_PatientRepositoryOutPort;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPatient_Service implements ReadUser_PatientCase {

    User_PatientRepositoryOutPort out;

    public UserPatient_Service(User_PatientRepositoryOutPort out) {
        this.out = out;
    }

    @Override
    public List<User> findAll() {
        return out.findAll();
    }
}
