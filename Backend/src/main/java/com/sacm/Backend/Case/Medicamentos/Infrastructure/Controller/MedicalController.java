package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller;

import com.sacm.Backend.Case.Medicamentos.Application.Service.MedicamentService;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalRequest;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalResponseDto;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.MedicalResponseMapperDto;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.RequestToMedicalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class MedicalController {

    @Autowired
    MedicamentService service;


    @GetMapping("/findAllMedicines")
    public List<MedicalResponseDto> FindAllMedicines() {
        return MedicalResponseMapperDto.listMedicamentos(service.findAll());
    }

    @GetMapping("/findMedicine/{id}")
    public MedicalResponseDto findByIdMedicine(@PathVariable Long id){
        return MedicalResponseMapperDto.toResponseDto(service.findById(id));
    }

    @PostMapping("/newMedicine")
    public MedicalResponseDto create(@RequestBody MedicalRequest request){
        return MedicalResponseMapperDto.toResponseDto(service.create(RequestToMedicalMapper.toMedical(request)));
    }

    @PostMapping("/deleteMedicine/{id}")
    public Boolean delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PostMapping("/updateMedicine")
    public MedicalResponseDto update(@RequestBody MedicalRequest request){
        return MedicalResponseMapperDto.toResponseDto(service.create(RequestToMedicalMapper.toMedical(request)));
    }









}
