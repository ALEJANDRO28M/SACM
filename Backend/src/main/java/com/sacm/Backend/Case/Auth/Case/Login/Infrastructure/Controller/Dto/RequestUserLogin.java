package com.sacm.Backend.Case.Auth.Case.Login.Infrastructure.Controller.Dto;

import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de transferencia de datos para el inicio de sesión de un usuario registrado en el sistema")
public record RequestUserLogin(

        @Schema(
                description = "Identificador único del usuario en la base de datos",
                example = "1024"
        )
        Long id,

        @Schema(
                description = "Nombre de usuario utilizado para autenticación. Debe ser único y contener entre 4 y 20 caracteres alfanuméricos.",
                example = "alejandro.dev"
        )
        String name,

        @Schema(
                description = "Contraseña del usuario en texto plano. Se recomienda encriptarla antes de persistir.",
                example = "MiClaveSegura123"
        )
        String password,

        @Schema(
                description = "Correo electrónico asociado al usuario. Debe tener formato válido.",
                example = "alejandro@example.com"
        )
        String email,

        String role,

        MedicEntity doctor
) {}
