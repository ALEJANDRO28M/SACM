package com.sacm.Backend.Case.Login.Infrastructure.Security;

import com.sacm.Backend.Case.Login.Application.Port.Out.SecurityPasswordOutPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * Adaptador de infraestructura encargado de codificar y verificar contraseñas
 * utilizando el algoritmo BCrypt. Implementa el puerto de salida {@link SecurityPasswordOutPort}
 * para desacoplar la lógica de seguridad del núcleo de la aplicación.
 */
@Repository
public class LoginEncodePasswordAdapter implements SecurityPasswordOutPort {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Codifica una contraseña en texto plano utilizando BCrypt.
     *
     * @param rawPassword contraseña original sin codificar
     * @return contraseña codificada
     */
    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verifica si una contraseña en texto plano coincide con una codificada.
     *
     * @param rawPassword contraseña original sin codificar
     * @param encodedPassword contraseña previamente codificada
     * @return true si coinciden, false en caso contrario
     */
    @Override
    public Boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
