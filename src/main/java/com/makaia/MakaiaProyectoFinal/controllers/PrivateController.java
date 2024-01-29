package com.makaia.MakaiaProyectoFinal.controllers;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import com.makaia.MakaiaProyectoFinal.enums.Programa;
import com.makaia.MakaiaProyectoFinal.enums.TipoDePerfilamiento;
import com.makaia.MakaiaProyectoFinal.services.Service;
import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("private")
public class PrivateController {
    private Service service;

    @Autowired
    public PrivateController(Service service) {
        this.service = service;
    }

    @PostMapping("/registrar_aspirante")
    public Aspirante crearAspirante(@RequestBody AspiranteDTO dto) {
        return this.service.crearAspirante(dto);
    }

    @GetMapping ("/actualzar_lista_de_pruebas_pendientes_por_finalizar")
    public ResponseEntity<String> actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla() {
        return this.service.actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla();
    }

    @PutMapping ("/modificar_programa")
    public Aspirante modificarPrograma(@RequestParam("idAspirante") Long idAspirante, @RequestParam("Programa") Programa programa) {
        return this.service.modificarPrograma(idAspirante, programa);
    }

    @PutMapping ("/modificar_celular")
    public Aspirante modificarCelular(@RequestParam("idAspirante") Long idAspirante, @RequestParam("Celular") Integer celular) {
        return this.service.modificarCelular(idAspirante, celular);
    }

    @PutMapping ("/modificar_direccion")
    public Aspirante modificarDireccionDeResidencia(@RequestParam("idAspirante") Long idAspirante, @RequestParam("Celular") String direccionDeResidencia) {
        return this.service.modificarDireccionDeResidencia(idAspirante, direccionDeResidencia);
    }

    @PutMapping ("/modificar_perfil_aspirante")
    public PerfilamientoAspirante modificarPerfilAspirante(@RequestParam("idAspirante") Long idAspirante, @RequestParam("idUsuario") Long idResponsableDePerfilarManual, @RequestParam("Perfil") PerfilAspirante nuevoPerfil) {
        return this.service.modificarPerfilAspirante(idAspirante, idResponsableDePerfilarManual,nuevoPerfil);
    }

    @GetMapping ("/listar_aspirantes")
    public List<Aspirante> listarAspirantes() {
        return this.service.listarAspirantes();
    }

    @GetMapping ("/listar_aspirante_por_programa/{programa}")
    public List<Aspirante> listarPerfilamientoPorPerfil(@PathVariable("programa") Programa programa) {
        return this.service.listarAspirantesPorPrograma(programa);
    }

    @GetMapping ("/listar_por_perfil/{perfil}")
    public List<PerfilamientoAspirante> listarPorPerfil(@PathVariable("perfil") PerfilAspirante perfilAspirante) {
        return this.service.listarPorPerfil(perfilAspirante);
    }

    @GetMapping ("/listar_por_tipo_de_perfilamiento/{tipoDePerfil}")
    public List<PerfilamientoAspirante> listarPorTipoDePerfilamiento(@PathVariable("tipoDePerfil") TipoDePerfilamiento tipoDePerfilamiento) {
        return this.service.listarPorTipoDePerfilamiento(tipoDePerfilamiento);
    }



}
