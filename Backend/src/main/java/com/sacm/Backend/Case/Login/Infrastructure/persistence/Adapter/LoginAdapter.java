package com.sacm.Backend.Case.Login.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginAdapter implements UserLoginRepositoryOutPort {

    SpringDataLogin crud;

    public LoginAdapter(SpringDataLogin crud) {
        this.crud = crud;
    }


    @Override
    public List<UserLogin> findAll() {
         return UserLoginMapper.toDomain(crud.findAll());
    }

    @Override
    public UserLogin findById(Long id) {
        return crud.findById(id).map(UserLoginMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("User no found"));
    }

    @Override
    public Boolean deleteById(Long id) {
        if (crud.existsById(id)){
            crud.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UserLogin create(UserLogin user) {
      return UserLoginMapper.toDomain(crud.save(UserLoginMapper.toEntity(user))) ;
    }

    @Override
    public UserLogin update(UserLogin user) {
        return UserLoginMapper.toDomain(crud.save(UserLoginMapper.toEntity(user))) ;
    }
}
