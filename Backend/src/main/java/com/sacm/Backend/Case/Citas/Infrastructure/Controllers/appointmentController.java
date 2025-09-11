package com.sacm.Backend.Case.Citas.Infrastructure.Controllers;

import com.sacm.Backend.Case.Citas.Application.Service.CitaService;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;
import com.sacm.Backend.Case.Citas.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaRequestMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaResponseMapper;


import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class appointmentController {

    @Autowired
     CitaService service;

    @CreateCitaDoc
    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody CitaRequest citaRequest) {
        CitaResponseMapper.citaToResponseDtoMapper(service.CreateCita(CitaRequestMapper.requestToCita(citaRequest)));
        return ResponseEntity.ok(ApiResult.success("Cita Creada correctamente."));
    }

    @FindAllCitaDoc
    @GetMapping("/CityPatient")
    public ResponseEntity<?> viewCities() {
         return ResponseEntity.ok(ApiResult.success(
                 CitaResponseMapper.toListResponseDto(service.findAllCitas()),
                 "Datos encontrados correctamente."));
    }

    @FindByIdCitaDoc
    @GetMapping("/CityFindById/{id}")
    public ResponseEntity<?> viewCityById(@PathVariable long id) {
        return ResponseEntity.ok(
                ApiResult.success(
                        CitaResponseMapper.citaToResponseDtoMapper(
                                service.findByIdCita(id)),
                        "Cita encontrada!"));
    }

    @UpdateCitaDoc
    @PostMapping("/CityUpdate")
    public ResponseEntity<?> updateCity(@RequestBody CitaRequest citaRequest) {
         return ResponseEntity.ok(
                 ApiResult.success(
                         CitaResponseMapper.citaToResponseDtoMapper(
                                 service.UpdateCita(CitaRequestMapper.requestToCita(citaRequest))),
                         "Cita Modificada correctamente."
                         ));
    }

    @DeleteCitaDoc
    @DeleteMapping("/CityDeleteById/{id}")
    public ResponseEntity<?> deleteCityById(@PathVariable Long id) {
                service.DeleteCita(id);
                return ResponseEntity.ok(ApiResult.success("Cita Eliminada correctamente."));
    }

}
