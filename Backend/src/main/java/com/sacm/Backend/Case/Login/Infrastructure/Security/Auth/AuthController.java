package com.sacm.Backend.Case.Login.Infrastructure.Security.Auth;

import com.sacm.Backend.Case.Login.Application.Service.UserServiceCase;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;
import com.sacm.Backend.Case.Login.Infrastructure.Documentation.CreateUserLoginDoc;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    @Autowired
    private final UserServiceCase crud;


    @CreateUserLoginDoc
    @PostMapping("/registerUser")
    public ResponseEntity<?> createUserLogin(@RequestBody RequestUserLogin request) {
        log.info("createUserLogin" + request.toString());

        ResponseEntity<?> response = (crud.create(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User create Successfully!"));
    }


    @PostMapping("/validarInicio")
    public ResponseEntity<?> login(@RequestBody RequestUserLogin request) {
        try{
            return ResponseEntity.ok(
                    ApiResult.success(
                            crud.loginUser(
                                    RequestLoginMapper.toDomain(request)
                            ),
                            "doctor encontrado"));
        }catch (Exception e){
            return null; //FALTA TERMINAR EL CATCH
            //ResponseEntity.ok(ApiResult.success());
        }

    }
}
