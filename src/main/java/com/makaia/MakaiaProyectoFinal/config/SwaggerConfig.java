package com.makaia.MakaiaProyectoFinal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
 -> Acá definen el tipo de seguridad que van a utiilizar. Ésta configuración está para JWT, pero deben consultar como hacerlo para autenticación básica
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "BearerAuth",
        scheme = "bearer",
        bearerFormat = "JWT"
)*/
@OpenAPIDefinition(
        info=@Info(
                title = "Evaluación y perfilamiento API"
                ),
        servers = {
                //debo reemplazar le url linea 15
             // @Server(url ="url del servidor que tenemos desplegado hasta el app para permitir el cors", description = "Servidor de producción"),
                @Server(url ="http://localhost:8082/", description = "Servidor local")
        }
)
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/public/**")
                .build();
    }

    @Bean
    public GroupedOpenApi privateApi() {
        return GroupedOpenApi.builder()
                .group("private")
                .pathsToMatch("/private/**")
                .build();
    }

}
