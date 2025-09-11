package com.sacm.Backend.Case.Citas.Infrastructure.Controllers;

import com.sacm.Backend.Case.Citas.Application.Service.CitaService;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;
import com.sacm.Backend.Case.Citas.Infrastructure.Documentation.*;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaRequestMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaResponseMapper;


import com.sacm.Backend.Common.Dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador REST para gestionar operaciones relacionadas con citas médicas.
 *
 * Este controlador expone endpoints HTTP para crear, consultar, actualizar y eliminar citas.
 * Utiliza el servicio {@link CitaService} como puerto de entrada de la capa de aplicación,
 * y mapea los datos entre DTOs y modelos de dominio mediante {@link CitaRequestMapper} y {@link CitaResponseMapper}.
 *
 * Las respuestas están estandarizadas mediante {@link ApiResult} y envueltas en {@link ResponseEntity}
 * para facilitar el control de códigos HTTP y mensajes.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Citas.Infrastructure.Controllers
 * 🧱 Capa: Infrastructure (exposición HTTP)
 * 🔁 Patrón: Hexagonal Architecture (Entrada/Salida)
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class appointmentController {

    @Autowired
    CitaService service;

    /**
     * Endpoint para crear una nueva cita médica.
     *
     * @param citaRequest DTO con los datos de la cita
     * @return mensaje de éxito envuelto en {@link ApiResult}
     */
    @CreateCitaDoc
    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody CitaRequest citaRequest) {
        CitaResponseMapper.citaToResponseDtoMapper(
                service.CreateCita(CitaRequestMapper.requestToCita(citaRequest))
        );
        return ResponseEntity.ok(ApiResult.success("Cita Creada correctamente."));
    }

    /**
     * Endpoint para obtener todas las citas registradas.
     *
     * @return lista de citas en formato {@link CitaResponse}, envuelta en {@link ApiResult}
     */
    @FindAllCitaDoc
    @GetMapping("/CityPatient")
    public ResponseEntity<?> viewCities() {
        return ResponseEntity.ok(ApiResult.success(
                CitaResponseMapper.toListResponseDto(service.findAllCitas()),
                "Datos encontrados correctamente."
        ));
    }

    /**
     * Endpoint para consultar una cita por su ID.
     *
     * @param id identificador único de la cita
     * @return cita encontrada en formato {@link CitaResponse}, envuelta en {@link ApiResult}
     */
    @FindByIdCitaDoc
    @GetMapping("/CityFindById/{id}")
    public ResponseEntity<?> viewCityById(@PathVariable long id) {
        return ResponseEntity.ok(ApiResult.success(
                CitaResponseMapper.citaToResponseDtoMapper(service.findByIdCita(id)),
                "Cita encontrada!"
        ));
    }

    /**
     * Endpoint para actualizar una cita existente.
     *
     * @param citaRequest DTO con los datos actualizados
     * @return cita modificada en formato {@link CitaResponse}, envuelta en {@link ApiResult}
     */
    @UpdateCitaDoc
    @PostMapping("/CityUpdate")
    public ResponseEntity<?> updateCity(@RequestBody CitaRequest citaRequest) {
        return ResponseEntity.ok(ApiResult.success(
                CitaResponseMapper.citaToResponseDtoMapper(
                        service.UpdateCita(CitaRequestMapper.requestToCita(citaRequest))
                ),
                "Cita Modificada correctamente."
        ));
    }

    /**
     * Endpoint para eliminar una cita por su ID.
     *
     * @param id identificador único de la cita
     * @return mensaje de éxito envuelto en {@link ApiResult}
     */
    @DeleteCitaDoc
    @DeleteMapping("/CityDeleteById/{id}")
    public ResponseEntity<?> deleteCityById(@PathVariable Long id) {
        service.DeleteCita(id);
        return ResponseEntity.ok(ApiResult.success("Cita Eliminada correctamente."));
    }
}
