package com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers;

import com.sacm.Backend.Case.Medicamentos.Domain.Models.Medicamentos;
import com.sacm.Backend.Case.Medicamentos.Infrastructure.Controller.Dto.MedicalRequest;

/**
 * Mapper encargado de transformar un {@link MedicalRequest} (DTO de entrada)
 * en un objeto del modelo de dominio {@link Medicamentos}.
 *
 * Este componente forma parte de la infraestructura y permite desacoplar la capa de exposición
 * del modelo de negocio, siguiendo los principios de la arquitectura hexagonal.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Medicamentos.Infrastructure.Mappers
 * 🧱 Capa: Infrastructure → Mapeo DTO → Dominio
 * 🔁 Flujo: Request DTO → Domain Model
 */
public class RequestToMedicalMapper {

    /**
     * Convierte un {@link MedicalRequest} en una instancia del modelo de dominio {@link Medicamentos}.
     *
     * @param request DTO recibido desde el cliente
     * @return objeto del modelo de dominio listo para ser procesado por la capa de aplicación
     */
    public static Medicamentos toMedical(MedicalRequest request) {
        return new Medicamentos(
                request.id(),
                request.nombre(),
                request.descripcion(),
                request.dosis(),
                request.frecuencia()
        );
    }
}
