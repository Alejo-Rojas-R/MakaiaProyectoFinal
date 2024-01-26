package com.makaia.MakaiaProyectoFinal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
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
public class SwaggerConfig {

}
