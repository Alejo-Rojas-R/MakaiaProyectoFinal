package com.makaia.MakaiaProyectoFinal.controllers;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.Programa;
import com.makaia.MakaiaProyectoFinal.services.Service;
import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/aspirantes")



public class PrivateController {
    private Service service;

    @Autowired
    public PrivateController(Service service) {
        this.service = service;
    }
    @PostMapping ("/crear-aspirante")
    public ResponseEntity<Aspirante> crear(
            @RequestBody Aspirante aspirante) {

        Aspirante aspiranteCreado = service.crearAspirante(
                aspirante.getPrograma(),
                aspirante.getEdad(),
                aspirante.getNacionalidad(),
                aspirante.getEstrato(),
                aspirante.getDiscapacidad(),
                aspirante.getNivelEducativo(),
                aspirante.getOcupacion(),
                aspirante.getSalario());

        return ResponseEntity.ok(aspiranteCreado);
    }
    @PostMapping("/asignar-programa")
    public Programa asignarPrograma(@RequestBody AspiranteDTO aspiranteDTO) {
        Programa programa = aspiranteDTO.getPrograma();
        return service.asignarPrograma(aspiranteDTO, programa);
    }
    @PutMapping ("/editar-programa")
    public void editarPrograma(@RequestParam Long idAspirante, @RequestParam Programa programa) {
        service.editarPrograma(idAspirante, programa);
    }


    @GetMapping ("/listar-aspirantes")
    public List<Aspirante> listarAspirantes() {
        return service.listarAspirantes();
    }


}
