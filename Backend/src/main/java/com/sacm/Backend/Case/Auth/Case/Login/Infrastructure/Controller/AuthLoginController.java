package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service.*;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Auth")
@Slf4j
public class AuthLoginController {


    private final LoginUserService loginUserService;


    @Autowired
    public AuthLoginController(
            LoginUserService loginUserService
    ) {
        this.loginUserService = loginUserService;
    }


    @PostMapping("/validarInicio")
    public ResponseEntity<?> login(@RequestBody RequestUserLogin request) {

        try{
            return loginUserService.loginUser( RequestLoginMapper.toDomain(request));
        }catch (Exception e){
            return null; //FALTA TERMINAR EL CATCH
            //ResponseEntity.ok(ApiResult.success());
        }

    }
}
