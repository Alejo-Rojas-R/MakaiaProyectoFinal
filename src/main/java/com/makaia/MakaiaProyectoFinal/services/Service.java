package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service


public class Service {
    AspiranteRepository aspiranteRepository;
    ProgramadorReposiroty programadorReposiroty;
    PerfilamientoAspiranteRepository perfilRepository;
    @Autowired
    public Service(AspiranteRepository aspiranteRepository, ProgramadorReposiroty programadorReposiroty, PerfilamientoAspiranteRepository perfilRepository) {
        this.aspiranteRepository = aspiranteRepository;
        this.programadorReposiroty = programadorReposiroty;
        this.perfilRepository = perfilRepository;
    }
    public Aspirante crearAspirante(Aspirante aspirante) {
        aspiranteRepository.save(aspirante);

        return aspirante;
    }
    public Programa asignarPrograma(AspiranteDTO aspiranteDTO, Programa programa){
        if (programa == null ) {
            throw new IllegalArgumentException("El programa no puede ser nulo o vacío");
        }
        Aspirante aspirante = this.aspiranteRepository.findById(aspiranteDTO.getId()).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );
        aspirante.setPrograma(programa);
        aspiranteRepository.save(aspirante);
        return programa;
    }
    public Aspirante editarPrograma(Long idAspirante, Programa programa) {

        Aspirante aspirante = aspiranteRepository.findById(idAspirante).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );

        aspirante.setPrograma(programa);

        return aspiranteRepository.save(aspirante);
    }

    public List<Aspirante> listarAspirantes() {
        return StreamSupport
                .stream(aspiranteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}




