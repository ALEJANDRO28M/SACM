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

@Slf4j
@Service
public class JwtUtilsImp implements JwtUtils {

    private final SecretKey key;

    public JwtUtilsImp(@Value("${jwt.secret-key}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }



    @Override
    public String extractUsername(String token) {
        return extractInfoClaim(token, Claims::getSubject);
    }

    @Override
    public <T> T extractInfoClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Claims getClaimsFromToken(String token) {
        //Tener en cuenta key de secretKey por si algo no funciona
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return null;
    }
//Metodo Que genera Claim
    @Override
    public String buildTokenWithData(UserDetails userDetails) {
        String subjectUsername = userDetails.getUsername();
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());
        claims.put("username", userDetails.getUsername());
        claims.put("password", userDetails.getPassword());
        return createToken(subjectUsername, claims);

    }

    //QUEDAMOS EN CREAR EL TOKEN
    @Override
    public String createToken(String subject, Map<String, Object> claimsInfo) {
        return Jwts.builder()
                .claims(claimsInfo)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 100 * 60 * 60))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public Date extractExpiration(String token) {
        return extractInfoClaim(token, Claims::getExpiration);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


}
