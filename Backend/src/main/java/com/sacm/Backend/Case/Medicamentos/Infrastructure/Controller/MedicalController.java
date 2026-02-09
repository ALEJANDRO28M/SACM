package com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller;

import com.sacm.Backend.Case.Medicamentos.Application.Service.MedicamentService;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalRequest;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.MedicalResponseMapperDto;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers.RequestToMedicalMapper;
import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class MedicalController {

    @Autowired
    MedicamentService service;

    @FindAllMedicalDoc
    @GetMapping("/findAllMedicines")
    public ResponseEntity<?> findAllMedicines() {
        return ResponseEntity.ok(
                ApiResult.success(
                        MedicalResponseMapperDto.listMedicamentos(service.findAll()),
                        "Medicamentos obtenidos correctamente"
                )
        );
    }

    @FindByIdMedicalDoc
    @GetMapping("/findMedicine/{id}")
    public ResponseEntity<?> findByIdMedicine(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResult.success(
                        MedicalResponseMapperDto.toResponseDto(service.findById(id)),
                        "Medicamento encontrado correctamente"
                )
        );
    }

    @CreateMedicalDoc
    @PostMapping("/newMedicine")
    public ResponseEntity<?> create(@RequestBody MedicalRequest request) {
        service.create(RequestToMedicalMapper.toMedical(request));
        return ResponseEntity.ok(
                ApiResult.success("Medicamento creado correctamente")
        );
    }

    @DeleteMedicalDoc
    @PostMapping("/deleteMedicine/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean result = service.delete(id);
        return ResponseEntity.ok(
                ApiResult.success(result ? "Medicamento eliminado correctamente" : "No se pudo eliminar el medicamento")
        );
    }

    @UpdateMedicalDoc
    @PostMapping("/updateMedicine")
    public ResponseEntity<?> update(@RequestBody MedicalRequest request) {
        service.create(RequestToMedicalMapper.toMedical(request));
        return ResponseEntity.ok(
                ApiResult.success("Medicamento actualizado correctamente")
        );
    }
}
