package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtUtils {

       String extractUsername(String token);
       <T> T extractInfoClaim(String token, Function<Claims,T> claimsResolver);
       //VALIDACIONES
       Claims getClaimsFromToken(String token);
       Boolean validateToken(String token, UserDetails userDetails);
       Boolean isTokenExpired(String token);
       String buildTokenWithData(UserDetails userDetails);
       String createToken(String subject, Map<String, Object> claims);
       Date extractExpiration(String token);

}
