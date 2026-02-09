package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * Interfaz JwtUtils
 *
 * <p>Define las operaciones necesarias para trabajar con tokens JWT en la aplicación.
 * Sus responsabilidades incluyen:
 * <ul>
 *   <li>Extraer información (username, claims, expiración) desde un token.</li>
 *   <li>Validar la firma y la validez de un token.</li>
 *   <li>Construir nuevos tokens JWT con datos personalizados.</li>
 * </ul>
 *
 * <p>Esta interfaz se implementa en {@link JwtUtilsImp}, que contiene la lógica
 * concreta de generación y validación de tokens.
 */
public interface JwtUtils {

       /**
        * Extrae el nombre de usuario (subject) desde el token JWT.
        *
        * @param token Token JWT firmado.
        * @return Nombre de usuario contenido en el claim "sub".
        */
       String extractUsername(String token);

       /**
        * Extrae un claim específico del token usando un resolver.
        *
        * @param token Token JWT firmado.
        * @param claimsResolver Función que indica qué claim se desea obtener.
        * @param <T> Tipo de dato esperado del claim.
        * @return Valor del claim solicitado.
        */
       <T> T extractInfoClaim(String token, Function<Claims, T> claimsResolver);

       /**
        * Obtiene todos los claims del token JWT.
        *
        * @param token Token JWT firmado.
        * @return Objeto {@link Claims} con la información del token.
        */
       Claims getClaimsFromToken(String token);

       /**
        * Valida un token JWT contra los datos de un usuario.
        *
        * @param token Token JWT firmado.
        * @param userDetails Información del usuario cargada desde BD.
        * @return true si el token es válido y corresponde al usuario.
        */
       boolean validateToken(String token, UserDetails userDetails);

       /**
        * Verifica si el token ha expirado.
        *
        * @param token Token JWT firmado.
        * @return true si el token está vencido.
        */
       boolean isTokenExpired(String token);

       /**
        * Construye un token JWT con los datos de un usuario.
        *
        * @param userDetails Información del usuario.
        * @return Token JWT firmado.
        */
       String buildTokenWithData(UserDetails userDetails);

       /**
        * Crea un token JWT con un subject y claims personalizados.
        *
        * @param subject Identificador principal del token (ej. username).
        * @param claims Mapa de claims adicionales.
        * @return Token JWT firmado.
        */
       String createToken(String subject, Map<String, Object> claims);

       /**
        * Extrae la fecha de expiración del token JWT.
        *
        * @param token Token JWT firmado.
        * @return Fecha de expiración.
        */
       Date extractExpiration(String token);
}
