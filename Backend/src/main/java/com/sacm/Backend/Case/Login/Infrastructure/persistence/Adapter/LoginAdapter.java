package com.sacm.Backend.Case.Login.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import com.sacm.Backend.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginAdapter implements UserLoginRepositoryOutPort {

    SpringDataLogin crud;

    SecurityService security;

    public LoginAdapter(SpringDataLogin crud, SecurityService security) {
        this.crud = crud;
        this.security = security;
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
        try {

            String encoded = security.encode(user.password());
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);
            return UserLoginMapper.toDomain(crud.save(entity)) ;

            }catch (Exception e){
             throw  new RuntimeException("NO SE PUDO CREAR",e);

        }

    }

    @Override
    public UserLogin update(UserLogin user) {
        try {

            String encoded = security.encode(user.password());
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);
            return UserLoginMapper.toDomain(crud.save(entity)) ;

        }catch (Exception e){
            throw  new RuntimeException("NO SE PUDO EDITAR",e);

        }
    }
}
