package com.sacm.Backend.Case.Login.Infrastructure.Controller;

import com.sacm.Backend.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Login.Application.Service.UserServiceCase;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserEncodePasswordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class UserLoginController {

    @Autowired
    UserServiceCase crud;

    @Autowired
    SecurityService security;

    @GetMapping("/findAllUserLogin")
    public List<ResponseUserLogin> findAllUserLogin() {
      return ResponseLoginMapper.toResponse(crud.findAll());
    }

    @DeleteMapping("/DeleteUserLogin/{id}")
    public Boolean deleteUserLogin(@PathVariable Long id) {
        return crud.deleteUserLogin(id);
    }


    @PostMapping("/CreateUserLogin")
    public ResponseUserLogin createUserLogin(@RequestBody RequestUserLogin request) {
           return ResponseLoginMapper.toResponse(crud.create(RequestLoginMapper.toDomain(request)));
    }

    @PostMapping("/UpdateUserLogin")
    public ResponseUserLogin updateUserLogin(@RequestBody RequestUserLogin request) {
        return ResponseLoginMapper.toResponse(crud.create(RequestLoginMapper.toDomain(request)));
    }
}
