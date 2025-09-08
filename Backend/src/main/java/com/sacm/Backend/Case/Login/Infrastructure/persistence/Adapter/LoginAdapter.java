package com.sacm.Backend.Case.Login.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import com.sacm.Backend.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Common.Exception.EmptyResultDataAccessException;
import com.sacm.Backend.Common.Exception.InternalServerException;
import com.sacm.Backend.Common.Exception.MethodArgumentNotValidException;
import com.sacm.Backend.Common.Exception.ResourceNotFoundException;
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
        try {
            return UserLoginMapper.toDomain(crud.findAll());
        } catch (RuntimeException e) {
                throw new InternalServerException("Error Persistence Content");
        }
    }

    @Override
    public UserLogin findById(Long id) {
        return crud.findById(id).map(UserLoginMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("User no found"));
    }

    @Override
        public Boolean deleteById(Long id) {
       try {
         crud.deleteById(id);
         return true;
       } catch (Exception e) {
         throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
       }
    }

    @Override
    public UserLogin create(UserLogin user) {
        try {

            String encoded = security.encode(user.password());
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);
            return UserLoginMapper.toDomain(crud.save(entity)) ;

            }catch (Exception e){
             throw  new MethodArgumentNotValidException("FALLO EN LAS VALIDACIONES DEL DTO A CONSULTAR!");
        }

    }

    @Override
    public UserLogin update(UserLogin user) {

        try {
            String encoded = security.encode(user.password());
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);
            return UserLoginMapper.toDomain(crud.save(entity)) ;

        }catch (Exception e){
            throw  new MethodArgumentNotValidException("FALLO EN LAS VALIDACIONES DEL DTO A CONSULTAR!");
        }

    }

}
