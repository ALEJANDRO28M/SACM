package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service.*;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto.ResponseUserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation.DeleteUserLoginDoc;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation.FindAllUserLoginDoc;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation.FindByIdUserLoginDoc;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Documentation.UpdateUserLoginDoc;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.ResponseLoginMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class UserLoginController {

    private final CreateUserService createUserService;
    private final DeleteUserService deleteUserService;
    private final FindAllUsersService findAllUsersService;
    private final UpdateUserService updateUserService;
    private final FindByIdUserService findByIdUserService;


    @Autowired
    public UserLoginController(

            CreateUserService createUserService,
            DeleteUserService deleteUserService,
            FindAllUsersService findAllUsersService,
            LoginUserService loginUserService,
            UpdateUserService updateUserService,

            FindByIdUserService findByIdUserService) {

        this.createUserService = createUserService;
        this.deleteUserService = deleteUserService;
        this.findAllUsersService = findAllUsersService;
        this.updateUserService = updateUserService;
        this.findByIdUserService = findByIdUserService;
    }
    @FindAllUserLoginDoc
    @GetMapping("/findAllUserLogin")
    public ResponseEntity<?> findAllUserLogin() {
        List<ResponseUserLogin> response = ResponseLoginMapper.toResponse(findAllUsersService.findAll());
      return ResponseEntity.ok(ApiResult.success(response,"Users brought correctly!"));
    }

    @DeleteUserLoginDoc
    @DeleteMapping("/DeleteUserLogin/{id}")
    public ResponseEntity<?> deleteUserLogin(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResult.success(deleteUserService.deleteUserLogin(id),"User Delete!"));
    }

    @UpdateUserLoginDoc
    @PostMapping("/UpdateUserLogin")
    public ResponseEntity<?> updateUserLogin(@RequestBody RequestUserLogin request) {
        ResponseUserLogin response = ResponseLoginMapper.toResponse(updateUserService.update(RequestLoginMapper.toDomain(request)));
        return ResponseEntity.ok(ApiResult.success(response,"User modified!"));
    }

    @FindByIdUserLoginDoc
    @GetMapping("/FindById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResult.success(ResponseLoginMapper.toResponse(findByIdUserService.findById(id)),"Usuario encontrado"));
    }

}
