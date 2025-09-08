package com.sacm.Backend.Case.Login.Infrastructure.Controller;

import com.sacm.Backend.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Login.Application.Service.UserServiceCase;
import com.sacm.Backend.Case.Login.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.UserEncodePasswordMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class UserLoginController {

    @Autowired
    UserServiceCase crud;

    @GetMapping("/findAllUserLogin")
    public ResponseEntity<?> findAllUserLogin() {
        List<ResponseUserLogin> response = ResponseLoginMapper.toResponse(crud.findAll());
      return ResponseEntity.ok(ApiResult.success(response,"Users brought correctly!"));
    }

    @DeleteMapping("/DeleteUserLogin/{id}")
    public ResponseEntity<?> deleteUserLogin(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResult.success(crud.deleteUserLogin(id),"User Deleted!"));
    }


    @PostMapping("/CreateUserLogin")
    public ResponseEntity<?> createUserLogin(@RequestBody RequestUserLogin request) {
        ResponseUserLogin response = ResponseLoginMapper.toResponse(crud.create(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User create Successfully!"));
    }

    @PostMapping("/UpdateUserLogin")
    public ResponseEntity<?> updateUserLogin(@RequestBody RequestUserLogin request) {
        ResponseUserLogin response = ResponseLoginMapper.toResponse(crud.create(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User modified!"));
    }
}
