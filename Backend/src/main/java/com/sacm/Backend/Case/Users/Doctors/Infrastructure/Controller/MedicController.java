package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller;

import com.sacm.Backend.Case.Users.Doctors.Application.Service.MedicService;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorRequest;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.DoctorToResponseMapper;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.RequestToMedicMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class MedicController {

    @Autowired
    MedicService medicService;

    @FindAllDoctorsDoc
    @GetMapping("/DataDoctor")
    public ResponseEntity<?> findAllMedic() {
        return ResponseEntity.ok(
                ApiResult.success(
                        DoctorToResponseMapper.medicoToListDoctor(
                                medicService.findAllMedico()
                        ),
                        "Listado de doctores obtenido correctamente"
                )
        );
    }

    @FindByIdDoctorsDoc
    @GetMapping("/findDoctorById/{id}")
    public ResponseEntity<?> findDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResult.success(
                        DoctorToResponseMapper.medicoToDoctorResponse(
                                medicService.findMedicoById(id)
                        ),
                        "Doctor encontrado correctamente"
                )
        );
    }

    @CreateDoctorDoc
    @PostMapping("/CreateDoctor")
    public ResponseEntity<?> createDoctor(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(
                ApiResult.success(
                        DoctorToResponseMapper.medicoToDoctorResponse(
                                medicService.create(
                                        RequestToMedicMapper.toMedico(doctorRequest)
                                )
                        ),
                        "Doctor creado exitosamente"
                )
        );
    }

    @UpdateDoctorsDoc
        @PostMapping("/UpdateDoctor")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorRequest doctorRequest) {
        System.out.println("Doctor update: " + doctorRequest.id());
        return ResponseEntity.ok(ApiResult.success(
              DoctorToResponseMapper.medicoToDoctorResponse(
                      medicService.updateMedic(
                              RequestToMedicMapper.toMedico(
                                      doctorRequest
                              ))),
                "Doctor actualizado correctamente"));
    }

    @DeleteDoctorDoc
    @DeleteMapping("/DeleteDoctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        medicService.deleteMedicUser(id);
        return ResponseEntity.ok(
                ApiResult.success("Doctor eliminado correctamente")
        );
    }
}
