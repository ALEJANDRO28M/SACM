package com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers;

import com.sacm.Backend.Case.Users.Doctors.Domain.Models.Medico;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.Controller.Dto.DoctorRequest;

/**
 * Mapper encargado de transformar un {@link DoctorRequest} (DTO de entrada)
 * en un objeto del modelo de dominio {@link Medico}.
 *
 * Este componente forma parte de la infraestructura y permite desacoplar la capa de exposición
 * del modelo de negocio, siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Users.Doctors.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo DTO → Dominio
 * 🔁 Flujo: Request DTO → Domain Model
 */
public class RequestToMedicMapper {

    /**
     * Convierte un {@link DoctorRequest} en una instancia del modelo de dominio {@link Medico}.
     *
     * @param doctorRequest DTO recibido desde el cliente
     * @return objeto del modelo de dominio listo para ser procesado por la capa de aplicación
     */
    public static Medico toMedico(DoctorRequest doctorRequest) {
        return new Medico(
                doctorRequest.id(),
                doctorRequest.nombre(),
                doctorRequest.apellido(),
                doctorRequest.edad(),
                doctorRequest.especialidad(),
                doctorRequest.telefono(),
                doctorRequest.email(),
                doctorRequest.description()
        );
    }
}
