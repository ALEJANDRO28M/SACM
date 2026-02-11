package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller;

import com.sacm.Backend.Case.Users.Doctors.Application.Service.MedicService;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorRequest;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.DoctorToResponseMapper;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.RequestToMedicMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
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

    //NO ESTAMOS RETORNANDO EL TOKEN DIRECTAMENTE, SI NO QUE ESTAMOS RETORNANDO UN OBJETO EN ESTE CASO,
    //LA ACTUALIZACION DE LOS DATOS
    /*
    * Posibles, repuestas o opciones a seguir
    * 1.Devolver el usuario aparte y el token aparte actualizado
    * 2.Devolver solamente el token actualizado y mediante otra solicitud extraer la informacion del doctor
    * para sea mostrada en la interfaz
    *
    * Opcion mas viable:
    * 1.Devolver el usuario aparte y el token aparte actualizado
    *
    * Fases a tener en cuenta:
    * Frontend:
    * 1.El localStorage solamente debe de almacenar el token, no el usuario deserializadoq
    * 2.Solamente se debe deeserializar el usuario nuevo que se va a mostrar en la interfaz
    *
    * Backend:
    * 1.Se debe de retornar un objeto o array que contenga el token  y el objeto medico con la informacion nueva del medico
    * 2.Verificar si estamos llamando el metodo que se encarga de crear un token nuevo
    *  */
    @UpdateDoctorsDoc
        @PostMapping("/UpdateDoctor")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorRequest doctorRequest) {
        log.info(doctorRequest.nombre());
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
