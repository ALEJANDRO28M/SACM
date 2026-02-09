package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Implementación personalizada de {@link UserDetailsService}.
 *
 * <p>Su responsabilidad es:
 * <ul>
 *   <li>Acceder al repositorio de usuarios para buscar un usuario por su nombre.</li>
 *   <li>Convertir la entidad {@link UserLoginEntity} en un objeto {@link UserDetails} que Spring Security pueda usar.</li>
 *   <li>Lanzar una excepción si el usuario no existe.</li>
 * </ul>
 *
 * <p>Spring Security utiliza esta clase durante el proceso de autenticación
 * para validar credenciales y construir el contexto de seguridad.
 */
@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    // Repositorio para acceder a la base de datos de usuarios
    private final SpringDataLogin springDataLogin;

    // Entidad del usuario cargada (puede usarse en otros métodos)
    private UserLoginEntity userDetails;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param springDataLogin Repositorio Spring Data para acceder a usuarios.
     */
    public CustomerDetailsService(SpringDataLogin springDataLogin) {
        this.springDataLogin = springDataLogin;
    }

    /**
     * Método principal de la interfaz {@link UserDetailsService}.
     *
     * <p>Busca un usuario en la base de datos por su nombre y lo convierte en
     * un objeto {@link UserDetails}. Si no existe, lanza {@link UsernameNotFoundException}.
     *
     * @param user Nombre de usuario a buscar.
     * @return Objeto {@link UserDetails} con la información del usuario.
     * @throws UsernameNotFoundException si el usuario no existe en la BD.
     */
    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        UserLoginEntity data = springDataLogin.findByUser(user);

        if (!Objects.isNull(data)) {
            return new DoctorUserDetails(data); // Clase personalizada que implementa UserDetails
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    /**
     * Devuelve la entidad del usuario cargada.
     *
     * @return Entidad {@link UserLoginEntity} con los datos del usuario.
     */
    public UserLoginEntity getUserDetails() {
        return userDetails;
    }
}
