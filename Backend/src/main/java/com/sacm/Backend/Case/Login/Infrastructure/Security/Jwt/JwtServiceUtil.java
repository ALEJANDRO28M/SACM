package com.sacm.Backend.Case.Login.Infrastructure.Security.Jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtServiceUtil {
   String extractUsername(String token);
   Date extractExpiration (String token);
   <T> T extractClaims(String token, Function<Claims, T> claimsResolver);
   Claims getClaimsFromToken(String token);
   Boolean validateInfoFromToken(String token, UserDetails userDetails);
   Boolean isTokenExpired(String token);
   String generateClaimInitToken(String username,String role);
   String createToken(String nameSubject, Map<String,Object> claims);
}
