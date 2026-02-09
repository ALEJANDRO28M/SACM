package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt;

import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.CustomerDetailsService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JwtFilter
 *
 * <p>Filtro que se ejecuta en cada petición HTTP para validar el token JWT.
 * Se encarga de:
 * <ul>
 *   <li>Extraer el token del header Authorization (Bearer).</li>
 *   <li>Validar la firma y los claims del token.</li>
 *   <li>Construir un objeto Authentication con los roles del usuario.</li>
 *   <li>Inyectar el Authentication en el SecurityContext.</li>
 * </ul>
 *
 * <p>Este filtro asegura que solo usuarios con un JWT válido puedan acceder
 * a los endpoints protegidos.
 */
@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    String username = null;
    Claims claims = null;

    private final CustomerDetailsService customerDetailsService;
    private final JwtUtilsImp util;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param util Utilidad para manejar JWT (extraer claims, validar firma, etc.)
     * @param customerDetailsService Servicio para cargar detalles del usuario desde BD.
     */
    public JwtFilter(JwtUtilsImp util, CustomerDetailsService customerDetailsService) {
        this.util = util;
        this.customerDetailsService = customerDetailsService;
    }

    /**
     * Filtro principal que intercepta cada petición HTTP.
     *
     * @param request  Petición HTTP entrante.
     * @param response Respuesta HTTP saliente.
     * @param filterChain Cadena de filtros de Spring Security.
     * @throws ServletException en caso de error de servlet.
     * @throws IOException en caso de error de I/O.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        log.info("INFORMACION TOKEN: {}", request.getHeader("Authorization"));

        String authorizationHeader = request.getHeader("Authorization");
        String token = null;

        // 1. Extraer token del header Authorization si empieza con "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = util.extractUsername(token);
            claims = util.getClaimsFromToken(token);
        }

        // 2. Validar que el usuario no esté ya autenticado
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = customerDetailsService.loadUserByUsername(username);

            // 3. Validar token contra los datos del usuario
            if (util.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 4. Inyectar Authentication en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 5. Continuar con el resto de filtros
        filterChain.doFilter(request, response);
    }
}
