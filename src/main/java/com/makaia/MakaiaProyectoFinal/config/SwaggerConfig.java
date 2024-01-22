package com.makaia.MakaiaProyectoFinal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
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
