package com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Controller;

import com.sacm.Backend.Case.Users.Users_Patients.Application.Service.UserPatient_Service;
import com.sacm.Backend.Case.Users.Users_Patients.Domain.User;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Controller.Dto.UserPatientRequest;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Controller.Dto.UserPatientResponse;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers.UserPatientRequestMapper;
import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.Mappers.UserToUserResponseMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import com.sacm.Backend.Common.Exception.CustomValidationException;
import com.sacm.Backend.Common.Exception.MethodArgumentNotValidException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class UserPatientController {

    @Autowired
    UserPatient_Service crud;

    @FindAllUserPatientDoc
    @GetMapping("/Data")
    public ResponseEntity<?> findAllUserPatients() {
        List<UserPatientResponse> response = UserToUserResponseMapper.toResponse(crud.findAll());
        return ResponseEntity.ok(ApiResult.success(response,"Users brought correctly!"));
    }

    @CreateUserPatientDoc
    @PostMapping("/CreateUserPatient")
    public ResponseEntity<?> createUserPatient(@RequestBody UserPatientRequest request) {
        crud.createUser(UserPatientRequestMapper.request(request));
        return ResponseEntity.ok(ApiResult.success("User create Successfully!"));
    }

    @UpdateUserPatientDoc
    @PostMapping("/updateUserPatient")
    public ResponseEntity<?> updateUserPatient(@RequestBody UserPatientRequest request) {
        crud.updateUser(UserPatientRequestMapper.request(request));
        return ResponseEntity.ok(ApiResult.success("User update Successfully!"));
    }

    @DeleteUserPatientDoc
    @DeleteMapping("/DeleteUserPatient/{id}")
    public ResponseEntity<?> deleteUserPatient(@RequestBody Long id) {
        crud.deleteUser(id);
        return ResponseEntity.ok(ApiResult.success("User delete Successfully!"));
    }

    @FindByIdUserPatientDoc
    @GetMapping("/FindByIdUserPatient/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResult.success(
                        UserToUserResponseMapper.toResponse(
                                crud.findById(id)
                        ),
                        "Usuario encontrado"
                ));
    }


}
