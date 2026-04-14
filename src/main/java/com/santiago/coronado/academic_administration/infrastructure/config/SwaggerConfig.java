package com.santiago.coronado.academic_administration.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión Académica - Santiago Coronado")
                        .version("1.0")
                        .description("Servicios REST para la gestión de estudiantes, materias y notas.")
                        .contact(new Contact()
                                .name("Santiago Coronado")
                                .email("santiago.coronado-p@mail.escuelaing.edu.co")));
    }
}