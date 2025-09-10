package com.sacm.Backend.Common.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
        /*
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "bearerAuth",
                                        new SecurityScheme()
                                                .name("bearerAuth")
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT"))) */

                .info(
                        new Info()
                                .title("SACM API")
                                .version("1.0.0")
                                .description("""
                                        Bienvenido a la documentación oficial de la API de SACM.

                                        Aquí encontrarás la descripción detallada de los distintos endpoints disponibles,
                                        sus métodos, parámetros de entrada, formatos de respuesta y ejemplos de uso.

                                        Te recomendamos seguir las instrucciones y ejemplos proporcionados para garantizar
                                        una correcta implementación y aprovechamiento de los servicios.
                                        """)
                );
        }
}
