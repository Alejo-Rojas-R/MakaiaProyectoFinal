package com.makaia.MakaiaProyectoFinal.consumer;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.PerfilamientoAspirannteDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.services.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    Service perfilamientoService;

/*
    @RabbitListener(queues = {"prueba_tecnica_enviada"}) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload AspiranteDTO aspirante){

        System.out.println("Crear un perfil para el aspirante " + aspirante.getNombre());
        this.perfilamientoService.crearPerfilamiento(aspirante);
    }*/
}
