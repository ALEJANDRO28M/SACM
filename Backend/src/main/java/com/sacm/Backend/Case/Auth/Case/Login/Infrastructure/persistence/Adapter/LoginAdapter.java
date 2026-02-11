package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Adapter;

import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.Out.*;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Service.Security.SecurityService;
import com.sacm.Backend.Case.Auth.Case.Domain.Models.UserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.UserLoginMapper;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.CustomerDetailsService;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt.JwtUtilsImp;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.RoleEntity;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories.SpringDataRole;
import com.sacm.Backend.Common.Dto.ApiResult;
import com.sacm.Backend.Common.Exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto de salida {@link UserLoginRepositoryOutPort}.
 * Se encarga de interactuar con la base de datos mediante {@link SpringDataLogin},
 * aplicar codificación de contraseñas con {@link SecurityService},
 * y mapear entre entidades y modelos de dominio usando {@link UserLoginMapper}.
 */
@Slf4j
@Service
public class LoginAdapter
        implements
        UserLoginRepositoryOutPort,
        CreateUserLoginOut,
        DeleteUserLoginOut,
        FindByIdUserOut,
        FindAllUserLoginOut,
        UpdateUserLoginOut {

    private final SpringDataLogin crud;
    private final SecurityService security;
    private final AuthenticationManager authenticationManager;
    private final JwtUtilsImp jwtToken;
    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param user modelo de dominio con los datos del usuario
     * @return modelo de dominio persistido
     * @throws MethodArgumentNotValidException si ocurre un err or en la validación o persistencia
     */
    @Autowired
    SpringDataRole dataRole;
    @Autowired
    private CustomerDetailsService customerDetailsService;

    /**
     * Constructor del adaptador de persistencia.
     *
     * @param crud     repositorio Spring Data JPA
     * @param security servicio de codificación de contraseñas
     */
    @Autowired
    public LoginAdapter(
            JwtUtilsImp jwtUtil,
            SpringDataLogin crud,
            SecurityService security,
            CustomerDetailsService customerDetailsService,
            AuthenticationManager authenticationManager
    ) {
        this.jwtToken = jwtUtil;
        this.crud = crud;
        this.security = security;
        this.customerDetailsService = customerDetailsService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Obtiene todos los usuarios registrados en la base de datos.
     *
     * @return lista de modelos de dominio {@link UserLogin}
     * @throws InternalServerException si ocurre un error inesperado en la persistencia
     */
    @Override
    public List<UserLogin> findAll() {
        try {
            return UserLoginMapper.toDomain(crud.findAll());
        } catch (RuntimeException e) {
            throw new InternalServerException("Error Persistence Content");
        }
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id identificador único del usuario
     * @return modelo de dominio {@link UserLogin}
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    @Override
    public UserLogin findById(Long id) {
        return crud.findById(id)
                .map(UserLoginMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("User no found"));
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id identificador único del usuario
     * @return true si la eliminación fue exitosa
     * @throws EmptyResultDataAccessException si el ID no existe en la base de datos
     */
    @Override
    public Boolean deleteById(Long id) {
        try {
            crud.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new EmptyResultDataAccessException("ID NO ENCONTRADO");
        }
    }

    @Override
    public ResponseEntity<?> create(UserLogin user) {
        try {
            // Buscar el rol existente en la BD
            RoleEntity roleEntity = dataRole.findByRole(user.role())
                    .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

            // Codificar la contraseña
            String encoded = security.encode(user.password());

            // Mapear el DTO a la entidad
            UserLoginEntity entity = UserLoginMapper.toEntity(user, encoded);

            // Asignar el rol existente
            entity.setRole(roleEntity);

            // Guardar el usuario
            UserLoginEntity saved = crud.save(entity);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Error de integridad en la base de datos: " + e.getMessage());
        }
    }


    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param user modelo de dominio con los datos actualizados
     * @return modelo de dominio actualizado
     * @throws MethodArgumentNotValidException si ocurre un error en la validación o persistencia
     */
    @Override
    public UserLogin update(UserLogin user) {

        Optional<UserLoginEntity> existenteOpt = crud.findById(user.id());

        if (existenteOpt.isEmpty()) {
            throw new ResourceNotFoundException("User not found, No se encontró el usuario a actualizar");
        }
        return UserLoginMapper.toDomain(
                crud.save(
                        UserLoginMapper.updateEntity(
                                user, existenteOpt.get()
                        )));
    }

    @Override
    public ResponseEntity<Map<String, String>> LoginUser(UserLogin login) {
        log.info(">>> Iniciando proceso de login para usuario: {}", login.name());

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.name(), login.password())
            );
            log.debug("Objeto Authentication recibido: {}", auth);
            log.info("¿Autenticado?: {}", auth.isAuthenticated());

            if (auth.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                log.info("Usuario autenticado correctamente: {}", userDetails.getUsername());

                String tokenBody = jwtToken.buildTokenWithData(userDetails);
                log.info("Token JWT generado: {}", tokenBody);

                Map<String, String> response = new HashMap<>();
                response.put("token", tokenBody);

                log.info(">>> Login exitoso para usuario: {}", userDetails.getUsername());
                return ResponseEntity.ok(response);
            } else {
                log.warn(">>> Fallo de autenticación: credenciales inválidas para usuario {}", login.name());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Uw"));
            }

        } catch (Exception e) {
            log.error(">>> Error inesperado durante login para usuario {}: {}", login.name(), e.getMessage(), e);
           throw new InternalServerException(STR."Error inesperado durante el login: \{e.getMessage()}");
        }
    }



    @Override
    public boolean deleteUserLogin(Long id) {
        //METODO AUN NO IMPLEMENTADO
        return false;
    }
}


