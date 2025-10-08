package com.sacm.Backend.Case.Login.Application.Service;

import com.sacm.Backend.Case.Login.Application.Port.In.*;
import com.sacm.Backend.Case.Login.Application.Port.Out.UserLoginRepositoryOutPort;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceCase  implements
        ReadUserLoginCase, DeleteUserLoginCase, CreateUserLoginCase, UpdateUserLoginCase, LoginUserCaseIn {

    UserLoginRepositoryOutPort crud;

    public UserServiceCase(UserLoginRepositoryOutPort crud) {
        this.crud = crud;
    }

    @Override
    public List<UserLogin> findAll() {
        return crud.findAll();
    }

    @Override
    public UserLogin findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public boolean deleteUserLogin(Long id) {
        return crud.deleteById(id);
    }

    @Override
    public UserLogin create(UserLogin user) {
        return crud.create(user);
    }

    @Override
    public UserLogin update(UserLogin user) {
        return crud.update(user);
    }

    @Override
    public Map<String,Object> loginUser(UserLogin login) {
      return  crud.LoginUser(login);
    }
}
