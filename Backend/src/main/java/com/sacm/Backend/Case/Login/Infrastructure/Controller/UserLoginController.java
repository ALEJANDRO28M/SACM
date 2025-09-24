package com.sacm.Backend.Case.Login.Infrastructure.Controller;

import com.sacm.Backend.Case.Login.Application.Service.UserServiceCase;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
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

    @FindAllUserLoginDoc
    @GetMapping("/findAllUserLogin")
    public ResponseEntity<?> findAllUserLogin() {
        List<ResponseUserLogin> response = ResponseLoginMapper.toResponse(crud.findAll());
      return ResponseEntity.ok(ApiResult.success(response,"Users brought correctly!"));
    }

    @DeleteUserLoginDoc
    @DeleteMapping("/DeleteUserLogin/{id}")
    public ResponseEntity<?> deleteUserLogin(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResult.success(crud.deleteUserLogin(id),"w"));
    }

    @CreateUserLoginDoc
    @PostMapping("/CreateUserLogin")
    public ResponseEntity<?> createUserLogin(@RequestBody RequestUserLogin request) {
        ResponseUserLogin response = ResponseLoginMapper.toResponse(crud.create(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User create Successfully!"));
    }

    @UpdateUserLoginDoc
    @PostMapping("/UpdateUserLogin")
    public ResponseEntity<?> updateUserLogin(@RequestBody RequestUserLogin request) {
        ResponseUserLogin response = ResponseLoginMapper.toResponse(crud.update(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User modified!"));
    }

    @FindByIdUserLoginDoc
    @GetMapping("/FindById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResult.success(ResponseLoginMapper.toResponse(crud.findById(id)),"Usuario encontrado"));
    }
    @PostMapping("/validarInicio")
    public Boolean login(@RequestBody RequestUserLogin request) {
           return crud.loginUser(RequestLoginMapper.toDomain(request));
    }
    //QUEDAMOS EN QUE HUBO UN PROBLEMA AL REALIZAR LA SOLICITUD EL ADAPTER ESTA BIEN LO QUE NO ESTA BIEN ES QUE NO PUED
    //INICIAR SESION, VALIDAR CON UN IF EN ADAPTER SI LA VALIDACION DEL PASSWORD FUE CORRECTA
}
