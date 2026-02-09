package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorResponse;

import java.util.List;

/**
 * Mapper encargado de transformar objetos del modelo de dominio {@link Medico}
 * en DTOs de salida {@link DoctorResponse}, utilizados en la capa de exposición (controladores).
 *
 * Este componente permite desacoplar la lógica de negocio de la representación HTTP,
 * siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo Dominio → DTO
 * 🔁 Flujo: Domain Model → Response DTO
 */
public class DoctorToResponseMapper {

    /**
     * Convierte un objeto {@link Medico} en un {@link DoctorResponse}.
     *
     * @param medico modelo de dominio
     * @return DTO para respuesta HTTP
     */
    public static DoctorResponse medicoToDoctorResponse(Medico medico) {
        return new DoctorResponse(
                medico.id(),
                medico.nombre(),
                medico.apellido(),
                medico.edad(),
                medico.especialidad(),
                medico.telefono(),
                medico.email(),
                medico.description()
        );
    }

    /**
     * Convierte una lista de objetos {@link Medico} en una lista de {@link DoctorResponse}.
     *
     * @param medico lista de modelos de dominio
     * @return lista de DTOs para respuesta HTTP
     */
    public static List<DoctorResponse> medicoToListDoctor(List<Medico> medico) {
        return medico.stream()
                .map(medic -> new DoctorResponse(
                        medic.id(),
                        medic.nombre(),
                        medic.apellido(),
                        medic.edad(),
                        medic.especialidad(),
                        medic.telefono(),
                        medic.email(),
                        medic.description()
                ))
                .toList();
    }
}
