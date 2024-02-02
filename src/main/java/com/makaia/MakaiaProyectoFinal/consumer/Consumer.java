package com.makaia.MakaiaProyectoFinal.consumer;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.services.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
/*
    @Autowired
    Service service;


    @RabbitListener(queues = {"pruebaTecnicaEnviada"}) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload AspiranteDTO aspirante){

        System.out.println("Crear un perfil para el aspirante " + aspirante.getNombre());
        this.service.crearPerfilamiento(aspirante);

    }*/
}
