package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller;
import com.sacm.Backend.Case.Auth.Case.Login.Application.Port.In.Service.*;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto.RequestUserLogin;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Mappers.RequestLoginMapper;
import com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Utils.Jwt.JwtUtilsImp;
import com.sacm.Backend.Common.Dto.ApiResult;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Auth")
@Slf4j
public class AuthLoginController {


    private final LoginUserService loginUserService;

    @Autowired
    public AuthLoginController(
            LoginUserService loginUserService
    ) {
        this.loginUserService = loginUserService;
    }


    @PostMapping("/validarInicio")
    public ResponseEntity<?> login(@RequestBody RequestUserLogin request, HttpServletResponse response) {
        log.info("INFORMACION LOGIN: {}", request.name());
        try {
            Map<String, String> responseMap = loginUserService.loginUser(RequestLoginMapper.toDomain(request));

            if (responseMap != null && responseMap.containsKey("refresh_token")) {
                // Crear cookie con el refresh token
                Cookie cookie = new Cookie("refresh_token", responseMap.get("refresh_token"));
                cookie.setHttpOnly(true); // no accesible desde JS
                cookie.setSecure(true);   // solo por HTTPS
                cookie.setPath("/");
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7 días

                response.addCookie(cookie);
                Map<String,String> tokenResponse = new HashMap<>();
                tokenResponse.put("token", responseMap.get("access_Token"));
                // Retornar el access token en el body
                return ResponseEntity.ok(tokenResponse);
            } else {
                // Caso en que el Map no tiene datos válidos
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(ApiResult.error("Credenciales inválidas o token no generado"));
            }
        } catch (Exception e) {
            log.error("Error en login", e);
            return ResponseEntity.badRequest()
                    .body(ApiResult.error("Error al iniciar sesión"));
        }
    }

}
