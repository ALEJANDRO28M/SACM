package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Implementación de la interfaz {@link JwtUtils}.
 *
 * <p>Esta clase contiene la lógica para:
 * <ul>
 *   <li>Generar tokens JWT firmados con una clave secreta.</li>
 *   <li>Extraer información (claims, username, expiración) desde un token.</li>
 *   <li>Validar la firma y vigencia de un token contra los datos de un usuario.</li>
 * </ul>
 *
 * <p>Se utiliza en el flujo de autenticación para emitir tokens al iniciar sesión
 * y validar tokens en cada petición protegida.
 */
@Slf4j
@Service
public class JwtUtilsImp implements JwtUtils {

    private final SecretKey key;

    /**
     * Constructor que inicializa la clave secreta usada para firmar y validar tokens.
     *
     * @param secretKey Clave secreta definida en application.properties (jwt.secret-key).
     */
    public JwtUtilsImp(@Value("${jwt.secret-key}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Extrae el nombre de usuario (subject) del token.
     *
     * @param token Token JWT firmado.
     * @return Nombre de usuario contenido en el claim "sub".
     */
    @Override
    public String extractUsername(String token) {
        return extractInfoClaim(token, Claims::getSubject);
    }

    /**
     * Extrae un claim específico del token usando un resolver.
     *
     * @param token Token JWT firmado.
     * @param claimsResolver Función que indica qué claim se desea obtener.
     * @param <T> Tipo de dato esperado del claim.
     * @return Valor del claim solicitado.
     */
    @Override
    public <T> T extractInfoClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Obtiene todos los claims del token JWT.
     *
     * @param token Token JWT firmado.
     * @return Objeto {@link Claims} con la información del token.
     */
    @Override
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Valida un token JWT contra los datos de un usuario.
     *
     * @param token Token JWT firmado.
     * @param userDetails Información del usuario cargada desde BD.
     * @return true si el token es válido y corresponde al usuario.
     */
    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * Genera un token JWT con claims adicionales basados en los datos del usuario.
     *
     * @param userDetails Información del usuario.
     * @return Token JWT firmado.
     */
    @Override
    public String buildTokenWithData(UserDetails userDetails) {
        String subjectUsername = userDetails.getUsername();
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());
        claims.put("username", userDetails.getUsername());
        claims.put("password", userDetails.getPassword()); // ⚠️ No recomendable incluir contraseñas en el token
        return createToken(subjectUsername, claims);
    }

    /**
     * Crea un token JWT con un subject y claims personalizados.
     *
     * @param subject Identificador principal del token (ej. username).
     * @param claimsInfo Mapa de claims adicionales.
     * @return Token JWT firmado.
     */
    @Override
    public String createToken(String subject, Map<String, Object> claimsInfo) {
        return Jwts.builder()
                .claims(claimsInfo)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extrae la fecha de expiración del token JWT.
     *
     * @param token Token JWT firmado.
     * @return Fecha de expiración.
     */
    @Override
    public Date extractExpiration(String token) {
        return extractInfoClaim(token, Claims::getExpiration);
    }

    /**
     * Verifica si el token ha expirado.
     *
     * @param token Token JWT firmado.
     * @return true si el token está vencido.
     */
    @Override
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
