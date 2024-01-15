package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilRepository;
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
    PerfilRepository perfilRepository;
    @Autowired
    public Service(AspiranteRepository aspiranteRepository, ProgramadorReposiroty programadorReposiroty, PerfilRepository perfilRepository) {
        this.aspiranteRepository = aspiranteRepository;
        this.programadorReposiroty = programadorReposiroty;
        this.perfilRepository = perfilRepository;
    }
    public Aspirante crearAspirante(

            Programa programa,
            Integer edad,
            String nacionalidad,
            Estrato estrato,
            Discapacidad discapacidad,
            NivelEducativo nivelEducativo,
            Ocupacion ocupacion,
            Salario salario) {

        Aspirante aspirante = new Aspirante();
        aspirante.setPrograma(programa);
        aspirante.setEdad(edad);
        aspirante.setNacionalidad(nacionalidad);
        aspirante.setEstrato(estrato);
        aspirante.setDiscapacidad(discapacidad);
        aspirante.setNivelEducativo(nivelEducativo);
        aspirante.setOcupacion(ocupacion);
        aspirante.setSalario(salario);


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




