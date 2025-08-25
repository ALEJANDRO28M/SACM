package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Port.Out.User_PatientRepositoryOutPort;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers.UserPatientMapper;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Repositories.SpringDataUserRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserPatientAdapter implements User_PatientRepositoryOutPort {

    SpringDataUserRepository crud;

    public UserPatientAdapter(SpringDataUserRepository crud) {
        this.crud = crud;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> saved = crud.findAll();
        return UserPatientMapper.toDomain(saved);
    }
}
