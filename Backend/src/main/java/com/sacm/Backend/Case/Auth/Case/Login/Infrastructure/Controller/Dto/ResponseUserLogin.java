package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta enviada al cliente tras un inicio de sesión exitoso. Contiene información básica del usuario y el token de autenticación.")
public record ResponseUserLogin(

        @Schema(
                description = "Identificador único del usuario en la base de datos",
                example = "1024"
        )
        Long id,

        @Schema(
                description = "Nombre de usuario registrado",
                example = "alejandro.dev"
        )
        String user,

        @Schema(
                description = "Token JWT generado tras la autenticación. Se utiliza para autorizar futuras solicitudes.",
                example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        )
        String token,

        @Schema(
                description = "Correo electrónico asociado al usuario",
                example = "alejandro@example.com"
        )
        String email
) {}
