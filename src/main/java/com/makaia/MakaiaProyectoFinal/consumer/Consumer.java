package com.makaia.MakaiaProyectoFinal.consumer;

import com.makaia.MakaiaProyectoFinal.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    AspiranteService perfilamientoService;

/*
    @RabbitListener(queues = {"prueba_tecnica_enviada"}) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload AspiranteDTO aspirante){

        System.out.println("Crear un perfil para el aspirante " + aspirante.getNombre());
        this.perfilamientoService.crearPerfilamiento(aspirante);
    }*/
}
