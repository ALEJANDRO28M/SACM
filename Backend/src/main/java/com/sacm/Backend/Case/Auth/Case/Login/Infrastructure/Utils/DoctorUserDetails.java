package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.persistence.Entities.UserLoginEntity;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Implementación personalizada de {@link UserDetails}.
 *
 * <p>Su responsabilidad es:
 * <ul>
 *   <li>Adaptar la entidad {@link UserLoginEntity} a un objeto que Spring Security pueda usar.</li>
 *   <li>Exponer información del usuario como username, password y roles.</li>
 *   <li>Permitir acceder a datos adicionales como el {@link MedicEntity} asociado.</li>
 * </ul>
 *
 * <p>Spring Security utiliza esta clase para construir el contexto de autenticación
 * y aplicar reglas de autorización basadas en roles.</p>
 */
public class DoctorUserDetails implements UserDetails {

    private final UserLoginEntity userLoginEntity;

    /**
     * Constructor que recibe la entidad del usuario.
     *
     * @param userLoginEntity Entidad con los datos del usuario.
     */
    public DoctorUserDetails(UserLoginEntity userLoginEntity) {
        this.userLoginEntity = userLoginEntity;
    }

    /**
     * Devuelve la entidad {@link MedicEntity} asociada al usuario.
     *
     * @return Entidad del médico vinculada al usuario.
     */
    public MedicEntity getDoctor() {
        return userLoginEntity.getDoctor();
    }

    /**
     * Devuelve los roles/autorizaciones del usuario.
     *
     * @return Lista de {@link GrantedAuthority} con el rol del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userLoginEntity.getRole().getRole()));
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña encriptada.
     */
    @Override
    public String getPassword() {
        return userLoginEntity.getPassword();
    }

    /**
     * Devuelve el nombre de usuario.
     *
     * @return Username del usuario.
     */
    @Override
    public String getUsername() {
        return userLoginEntity.getUser();
    }

    /**
     * Indica si la cuenta está expirada.
     *
     * @return true si la cuenta no está expirada.
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     * Indica si la cuenta está bloqueada.
     *
     * @return true si la cuenta no está bloqueada.
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     * Indica si las credenciales están expiradas.
     *
     * @return true si las credenciales no están expiradas.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     * Indica si la cuenta está habilitada.
     *
     * @return true si la cuenta está habilitada.
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
