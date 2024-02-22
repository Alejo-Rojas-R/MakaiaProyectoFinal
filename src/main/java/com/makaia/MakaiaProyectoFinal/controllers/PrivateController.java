package com.makaia.MakaiaProyectoFinal.controllers;
import com.makaia.MakaiaProyectoFinal.dtos.ModificarAspiranteDTO;
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

    @GetMapping ("/actualizar_lista_de_pruebas_pendientes_por_finalizar")
    public ResponseEntity<String> actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla() {
        return this.service.actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla();
    }

    @PutMapping ("/modificar_aspirante")
    public Aspirante modificarAspirante(@RequestParam("id") Long idAspirante, @RequestBody AspiranteDTO dto) {
        return this.service.modificarAspirante(idAspirante, dto);
    }

    @PutMapping ("/modificar_perfil_aspirante/{id}")
    public PerfilamientoAspirante modificarPerfilAspirante(@PathVariable("id") Long idAspirante, @RequestParam("idUsuario") Long idResponsableDePerfilarManual, @RequestParam("Perfil") PerfilAspirante nuevoPerfil) {
        return this.service.modificarPerfilAspirante(idAspirante, idResponsableDePerfilarManual,nuevoPerfil);
    }

    @GetMapping ("/leer_aspirante_por_id")
    public Aspirante leerAspirante(@RequestParam("id") Long idAspirante) {
        return this.service.leerAspirante(idAspirante);
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

    @GetMapping ("/listar_por_documento")
    public List<Aspirante> listarPorDocumento(@RequestParam("documento") String documento) {
        return this.service.listarPorDocumento(documento);
    }

    @DeleteMapping("/eliminar_aspirante")
    public ResponseEntity<String> eliminarAspirante(@RequestParam("id") Long id) {
        return this.service.eliminarAspirante(id);
    }
}
