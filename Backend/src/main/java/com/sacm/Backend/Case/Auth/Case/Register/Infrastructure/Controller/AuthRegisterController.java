package com.sacm.Backend.Case.Auth.Case.Register.Infrastructure.Controller;

import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service.CreateUserService;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation.CreateUserLoginDoc;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Auth")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthRegisterController {

    @Autowired
    private final CreateUserService createUserService;


    @CreateUserLoginDoc
    @PostMapping("/registerUser")
    public ResponseEntity<?> createUserLogin(@RequestBody RequestUserLogin request) {
        log.info("createUserLogin" + request.toString());

        ResponseEntity<?> response = (createUserService.create(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User create Successfully!"));
    }

}
