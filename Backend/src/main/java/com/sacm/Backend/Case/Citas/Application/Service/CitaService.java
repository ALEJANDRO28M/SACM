package com.sacm.Backend.Case.Citas.Application.Service;

import com.sacm.Backend.Case.Citas.Application.Port.In.CreateCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.DeleteCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.ReadCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.In.UpdateCitaCase;
import com.sacm.Backend.Case.Citas.Application.Port.Out.CitaRepository_OutPort;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de aplicación para la gestión de citas.
 * <p>
 * Implementa los casos de uso definidos en los puertos de entrada:
 * {@link CreateCitaCase}, {@link DeleteCitaCase}, {@link ReadCitaCase}, {@link UpdateCitaCase}.
 * <p>
 * Este servicio actúa como intermediario entre la capa de aplicación y el puerto de salida
 * {@link CitaRepository_OutPort}, delegando las operaciones de persistencia.
 *
 * <h2>Responsabilidades:</h2>
 * <ul>
 *   <li>Crear nuevas citas en el sistema.</li>
 *   <li>Eliminar citas existentes por su identificador.</li>
 *   <li>Consultar citas individuales o todas las citas registradas.</li>
 *   <li>Actualizar la información de una cita existente.</li>
 * </ul>
 *
 * <h2>Excepciones:</h2>
 * <ul>
 *   <li>Puede lanzar excepciones personalizadas si el repositorio falla o si la cita no existe.</li>
 * </ul>
 */
@Service
public class CitaService
        implements
        CreateCitaCase,
        DeleteCitaCase,
        ReadCitaCase,
        UpdateCitaCase {

    private final CitaRepository_OutPort citaRepository_outPort;

    /**
     * Constructor del servicio de citas.
     *
     * @param citaRepository_outPort puerto de salida para operaciones de persistencia de citas.
     */
    public CitaService(CitaRepository_OutPort citaRepository_outPort) {
        this.citaRepository_outPort = citaRepository_outPort;
    }

    /**
     * Crea una nueva cita en el sistema.
     *
     * @param citas objeto {@link Citas} con la información de la cita a crear.
     * @return la cita creada con su identificador asignado.
     */
    @Override
    public Citas CreateCita(Citas citas) {
        return citaRepository_outPort.create(citas);
    }

    /**
     * Elimina una cita existente por su identificador.
     *
     * @param id identificador único de la cita.
     * @return {@code true} si la cita fue eliminada exitosamente, {@code false} en caso contrario.
     */
    @Override
    public boolean DeleteCita(Long id) {
        return citaRepository_outPort.delete(id);
    }

    /**
     * Busca una cita por su identificador.
     *
     * @param id identificador único de la cita.
     * @return la cita encontrada o {@code null} si no existe.
     */
    @Override
    public Citas findByIdCita(Long id) {
        return citaRepository_outPort.findById(id);
    }

    /**
     * Obtiene todas las citas registradas en el sistema.
     *
     * @return lista de objetos {@link Citas}.
     */
    @Override
    public List<Citas> findAllCitas() {
        return citaRepository_outPort.findAll();
    }

    /**
     * Actualiza la información de una cita existente.
     *
     * @param citas objeto {@link Citas} con la información actualizada.
     * @return la cita actualizada.
     */
    @Override
    public Citas UpdateCita(Citas citas) {
        return citaRepository_outPort.update(citas);
    }
}
