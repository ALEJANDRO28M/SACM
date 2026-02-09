package com.sacm.Backend.Case.HistorialMedico.Infrastructure.Documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Operation(
      summary = "Obtención de historial medico por ID",
        description = """
        Este endpoint permite obtener la información del historial medico
        mediante su identificador único. Retorna los siguientes datos:
        ID, FECHA, DIAGNOSTICO, TRATAMIENTO.
       """
)
@ApiResponses({
        @ApiResponse()
})
public @interface HistoryDoctorDoc {
}
