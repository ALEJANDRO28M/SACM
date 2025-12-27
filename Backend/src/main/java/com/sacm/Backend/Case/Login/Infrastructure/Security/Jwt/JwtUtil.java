package com.sacm.Backend.Case.Login.Infrastructure.Security.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil implements JwtServiceUtil {


    private final SecretKey key;

    public JwtUtil(@Value("${jwt.secret-key}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Claims getClaimsFromToken(String token) {
        return Jwts
                .parser()
                .verifyWith(key)
                .build().parseSignedClaims(token).getPayload();
    }

    @Override
    public Boolean validateInfoFromToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        //VALIDAR SI EL TOKEN NO ESTA EXPIRADO, USAR SIMBOLO
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public Boolean isTokenExpired(String token) {
        final Date expiration = extractExpiration(token);
        /*
        * expiration.before =(expiration) hace referencia a una fecha en especificio, ejemplo 24-dic hora 11:00 pm
        * y con el before hace referencia a que si la fecha de expiracion esta antes a la que se pasa por parametro
        * que es la actual, quiere decir que el token ya expiro, quiere decir que retorna un true.
        * */
        return (expiration.before(new Date()));
    }

    //Creamos el claim inicial pára despues implementarlo en el token
    //contiene map que adjunta el nombre y el role del usuario,
    //puede ser user o admin
    @Override
    public String generateClaimInitToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role",role);
        return createToken(username,claims);
    }

    @Override
    public String createToken(String nameSubject, Map<String, Object> claims) {
        return Jwts
                .builder()
                .claims(claims)
                .subject(nameSubject)
                //FECHA EN QUE SE CREA EL TOKEN
                .issuedAt(new Date(System.currentTimeMillis()))
                //FECHA DE EXPIRACION DEL TOKEN
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                //Llave con la que se firma el token
                .signWith(key)
                //Compactar y crear token con info dada
                .compact();

    }
}
