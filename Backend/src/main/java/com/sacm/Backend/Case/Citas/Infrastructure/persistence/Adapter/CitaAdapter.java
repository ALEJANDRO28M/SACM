package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Citas.Application.Port.Out.CitaRepository_OutPort;
import com.sacm.Backend.Case.Citas.Domain.Models.Citas;
import com.sacm.Backend.Case.Citas.Infrastructure.Mappers.CitasMapper;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities.CitasEntitys;
import com.sacm.Backend.Case.Citas.Infrastructure.persistence.Repositories.SpringDateCitasRepository;
import com.sacm.Backend.Common.Exception.EmptyResultDataAccessException;
import com.sacm.Backend.Common.Exception.InternalServerException;
import com.sacm.Backend.Common.Exception.MethodArgumentNotValidException;
import com.sacm.Backend.Common.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para la entidad {@link Citas}, implementando el puerto de salida {@link CitaRepository_OutPort}.
 *
 * Esta clase se encarga de traducir entre el modelo de dominio {@link Citas} y la entidad de base de datos {@link CitasEntitys},
 * utilizando el mapper {@link CitasMapper}. Interactúa con el repositorio JPA {@link SpringDateCitasRepository} para realizar
 * operaciones CRUD sobre la base de datos.
 *
 * Maneja excepciones específicas para cada operación, permitiendo una gestión centralizada de errores y respuestas controladas.
 *
 * 📦 Ubicación: com.sacm.Backend.Case.Citas.Infrastructure.persistence.Adapter
 * 🧱 Capa: Infrastructure (adaptador de persistencia)
 * 🔁 Patrón: Hexagonal Architecture (Puerto/Adaptador)
 */
@Repository
public class CitaAdapter implements CitaRepository_OutPort {

    private final SpringDateCitasRepository springDateCitasRepository;

    /**
     * Constructor que inyecta el repositorio JPA para citas.
     *
     * @param springDateCitasRepository repositorio Spring Data JPA
     */
    public CitaAdapter(SpringDateCitasRepository springDateCitasRepository) {
        this.springDateCitasRepository = springDateCitasRepository;
    }

    /**
     * Crea una nueva cita en la base de datos.
     *
     * @param citas modelo de dominio con los datos de la cita
     * @return cita creada como modelo de dominio
     * @throws MethodArgumentNotValidException si falla la validación del DTO
     */
    @Override
    public Citas create(Citas citas) {
        try {
            CitasEntitys citasEntity = CitasMapper.toEntity(citas);
            CitasEntitys savedEntity = springDateCitasRepository.save(citasEntity);
            return CitasMapper.toDomain(savedEntity);
        } catch (Exception e) {
            throw new MethodArgumentNotValidException("FALLO EN LAS VALIDACIONES DEL DTO A CREAR!");
        }
    }

    /**
     * Elimina una cita por su ID.
     *
     * @param id identificador único de la cita
     * @return true si la cita fue eliminada correctamente
     * @throws EmptyResultDataAccessException si el ID no existe en la base de datos
     */
    @Override
    public boolean delete(Long id) {
        if (!springDateCitasRepository.existsById(id)) {
            throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
        }
        return  springDateCitasRepository.existsById(id);
    }

    /**
     * Actualiza los datos de una cita existente.
     *
     * @param citas modelo de dominio con los datos actualizados
     * @return cita actualizada como modelo de dominio
     * @throws MethodArgumentNotValidException si falla la validación del DTO
     */
    @Override
    public Citas update(Citas citas) {

         Optional<CitasEntitys> existing = springDateCitasRepository.findById(citas.id());
         if (existing.isEmpty()){
             throw new ResourceNotFoundException("Cita no encontrada, no se encontro la cita a actualizar");
         }
         final CitasEntitys updateEntity = existing.get();
         updateEntity.setUser(citas.user());
         return CitasMapper.toDomain(springDateCitasRepository.save(existing.get()));
    }
    /**
     * Busca una cita por su ID.
     *
     * @param id identificador único de la cita
     * @return cita encontrada como modelo de dominio
     * @throws ResourceNotFoundException si no se encuentra la cita
     */
    @Override
    public Citas findById(Long id) {
        return springDateCitasRepository.findById(id)
                .map(CitasMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Citas no encontrada"));
    }

    /**
     * Obtiene todas las citas registradas en la base de datos.
     *
     * @return lista de citas como modelos de dominio
     * @throws InternalServerException si ocurre un error inesperado en la persistencia
     */
    @Override
    public List<Citas> findAll() {
        try {
            final List<CitasEntitys> savedEntity = springDateCitasRepository.findAll();
            return CitasMapper.toListCitas(savedEntity);
        } catch (Exception e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }
}
