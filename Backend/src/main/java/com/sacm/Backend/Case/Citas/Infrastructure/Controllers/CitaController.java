package com.sacm.Backend.Case.Citas.Infrastructure.Controllers;
import com.sacm.Backend.Case.Citas.Application.Port.In.DeleteCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.ReadCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.UpdateCitaCase;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Application.Port.In.CreateCitaCase;
import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaRequest;

import com.sacm.Backend.Case.Citas.Infrastructure.Controllers.Dto.CitaResponse;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaRequestMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitaResponseMapper;

import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Api")
public class CitaController {

    private final CreateCitaCase createCitaCase;
    private final DeleteCitaCase deleteCitaCase;
    private final UpdateCitaCase updateCitaCase;
    private final ReadCitaCase readCitaCase;

    public CitaController(CreateCitaCase createCitaCase, DeleteCitaCase deleteCitaCase, UpdateCitaCase updateCitaCase, ReadCitaCase readCitaCase) {
        this.createCitaCase = createCitaCase;
        this.deleteCitaCase = deleteCitaCase;
        this.updateCitaCase = updateCitaCase;
        this.readCitaCase = readCitaCase;
    }

    @PostMapping("/create")
    public CitaResponse createCita(@RequestBody CitaRequest citaRequest) {
        final Citas citas = new Citas(citaRequest.id(),citaRequest.fecha(), citaRequest.motivo(), citaRequest.historialMedico(),citaRequest.user());
        final Citas response = createCitaCase.CreateCita(citas);
        return new CitaResponse(response.id(),response.fecha(),response.motivo(),response.historialMedico(),response.user());
    }


    @GetMapping("/CitasPacientes")
    public List<CitaResponse> viewCitas() {
        return CitaResponseMapper.toListResponseDto(readCitaCase.findAllCitas());
    }

    @GetMapping("/CitasFindById")
    public Citas viewCitaById(@RequestParam long id) {
      return readCitaCase.findByIdCita(id);
    }

    @PostMapping("/CitaUpdate")
    public Citas updateCita(@RequestBody CitaRequest citaRequest) {
        return updateCitaCase.UpdateCita(CitaRequestMapper.requestToCita(citaRequest));
    }

    @PostMapping("/CitaDeleteById/{id}")
    public Boolean deleteCitaById(@PathVariable Long id) {
        return deleteCitaCase.DeleteCita(id);
    }
/*
queda para correlacionarlo con el paciente ya que no se puede acceder directamente al paciente , porque aun no esta terminado la capa
hexagonal del paciente

    @GetMapping("/citPatientId/{id}")
    public void cita_Patient_findById(@PathVariable Integer id) {
        readCitaCase.findByIdCita()
    }
*/

}
