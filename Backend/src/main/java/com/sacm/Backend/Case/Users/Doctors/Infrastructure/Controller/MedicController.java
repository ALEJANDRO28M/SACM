package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller;

import com.sacm.Backend.Case.Users.Doctors.Application.Service.MedicService;
import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorRequest;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorResponse;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.DoctorToResponseMapper;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers.RequestToMedicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class MedicController {

    @Autowired
    MedicService  medicService;

    //MAPEOS NECESARIO MEDICREQUESTMAPPER Y MEDICRESPONSEMAPPER

    @GetMapping("/DataDoctor")
    public List<DoctorResponse> findAllMedic() {
        return DoctorToResponseMapper.medicoToListDoctor(medicService.findAllMedico());
    }

    @GetMapping("/findDoctorById/{id}")
    public DoctorResponse findDoctorById(@PathVariable Long id){
        return DoctorToResponseMapper.medicoToDoctorResponse(medicService.findMedicoById(id));
    }

    @PostMapping("/CreateDoctor")
    public DoctorResponse createDoctor(@RequestBody DoctorRequest doctorRequest){
        final Medico saved = medicService.create(RequestToMedicMapper.toMedico(doctorRequest));
        return DoctorToResponseMapper.medicoToDoctorResponse(saved);
    }

    @PostMapping("/UpdateDoctor")
    public DoctorResponse updateDoctor(@RequestBody DoctorRequest doctorRequest){
        final Medico saved = medicService.updateMedic(RequestToMedicMapper.toMedico(doctorRequest));
        return DoctorToResponseMapper.medicoToDoctorResponse(saved);
    }

    @DeleteMapping("/DeleteDoctor/{id}")
    public Boolean deleteDoctor(@PathVariable Long id){
        return medicService.deleteMedicUser(id);
    }

}
