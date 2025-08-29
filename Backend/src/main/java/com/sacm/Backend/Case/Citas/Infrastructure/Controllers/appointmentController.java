package com.sacm.Backend.Case.Citas.Infrastructure.Controllers;

import com.sacm.Backend.Case.Citas.Application.Service.CitaService;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaRequestMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaResponseMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class appointmentController {

    @Autowired
     CitaService service;

    @PostMapping("/create")
    public CitaResponse createCity(@RequestBody CitaRequest citaRequest) {

        final Citas response = service.CreateCita(CitaRequestMapper.requestToCita(citaRequest));
        return  CitaResponseMapper.citaToResponseDtoMapper(response);

    }


    @GetMapping("/CityPatient")
    public List<CitaResponse> viewCities() {
        return CitaResponseMapper.toListResponseDto(service.findAllCitas());
    }

    @GetMapping("/CityFindById/{id}")
    public CitaResponse viewCityById(@PathVariable long id) {
        return CitaResponseMapper.citaToResponseDtoMapper(service.findByIdCita(id));
    }

    @PostMapping("/CityUpdate")
    public CitaResponse updateCity(@RequestBody CitaRequest citaRequest) {
        final Citas saved = service.UpdateCita(CitaRequestMapper.requestToCita(citaRequest));
        return CitaResponseMapper.citaToResponseDtoMapper(saved);
    }

    @DeleteMapping("/CityDeleteById/{id}")
    public Boolean deleteCityById(@PathVariable Long id) {
        return service.DeleteCita(id);
    }

}
