package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;

import java.util.Date;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service


public class AspiranteService {
    AspiranteRepository aspiranteRepository;
    ProgramadorReposiroty programadorReposiroty;
    PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;

    public AspiranteService() {
    }

    @Autowired
    public AspiranteService(AspiranteRepository aspiranteRepository, ProgramadorReposiroty programadorReposiroty, PerfilamientoAspiranteRepository perfilamientoAspiranteRepository) {
        this.aspiranteRepository = aspiranteRepository;
        this.programadorReposiroty = programadorReposiroty;
        this.perfilamientoAspiranteRepository = perfilamientoAspiranteRepository;
    }
    public Aspirante crearAspirante(
            Long id,
            Programa programa,
            String nombre,
            TipoDocumento tipoDocumento,
            Integer numDocumento,
            Genero genero,
            int edad,
            Date nacimiento,
            Integer celular,
            String email,
            Departamento departamento,
            String ciudad,
            String direccionResidencia,
            Estrato estrato,
            Reconocimiento reconocimiento,
            Discapacidad discapacidad,
            Poblacion poblacion,
            NivelEducativo nivelEducativo,
            Ocupacion ocupacion,
            String ultimoTituloAcademico,
            String estudioTrabajo,
            Salario salario,
            String tiempoLibre) {

        Aspirante aspirante = new Aspirante();
        aspirante.setId(id);
        aspirante.setPrograma(programa);
        aspirante.setNombre(nombre);
        aspirante.setTipoDocumento(tipoDocumento);
        aspirante.setNumDocumento(numDocumento);
        aspirante.setGenero(genero);
        aspirante.setEdad(edad);
        aspirante.setNacimiento(nacimiento);
        aspirante.setCelular(celular);
        aspirante.setEmail(email);
        aspirante.setDepartamento(departamento);
        aspirante.setCiudad(ciudad);
        aspirante.setDireccionResidencia(direccionResidencia);
        aspirante.setEstrato(estrato);
        aspirante.setReconocimiento(reconocimiento);
        aspirante.setDiscapacidad(discapacidad);
        aspirante.setPoblacion(poblacion);
        aspirante.setNivelEducativo(nivelEducativo);
        aspirante.setOcupacion(ocupacion);
        aspirante.setUltimoTituloAcademico(ultimoTituloAcademico);
        aspirante.setEstudioTrabajo(estudioTrabajo);
        aspirante.setSalario(salario);
        aspirante.setTiempoLibre(tiempoLibre);


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




