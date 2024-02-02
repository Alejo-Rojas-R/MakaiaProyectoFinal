package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.PerfilamientoAspirannteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadoDeAspiranteTestGorillaDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadosTestGorillaResponseDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.entities.ValidadorDeTestGorilla;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.publisher.Publisher;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@org.springframework.stereotype.Service
public class Service extends AbstractClient {

    private AspiranteRepository aspiranteRepository;
    private ProgramadorReposiroty programadorReposiroty;
    private PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;
    private Publisher publisher;
    private UsuarioRepository usuarioRepository;


    @Autowired
    public Service(AspiranteRepository aspiranteRepository, ProgramadorReposiroty programadorReposiroty,
                   PerfilamientoAspiranteRepository perfilamientoAspiranteRepository, RestTemplate restTemplate, Publisher publisher, UsuarioRepository usuarioRepository) {
        super(restTemplate);
        this.aspiranteRepository = aspiranteRepository;
        this.programadorReposiroty = programadorReposiroty;
        this.perfilamientoAspiranteRepository = perfilamientoAspiranteRepository;
        this.publisher = publisher;
        this.usuarioRepository = usuarioRepository;
    }

    public Aspirante crearAspirante(AspiranteDTO dto) {

        Optional<Aspirante> existeAspirante = this.aspiranteRepository.findByEmail(dto.getEmail());
        if (existeAspirante.isPresent()) {
            throw new ApiException("El aspirante ya existe", HttpStatusCode.valueOf(400));
        }

        Aspirante nuevoAspirate = new Aspirante(dto.getIdAspirantePrueba(),
                dto.getPrograma(),
                dto.getNombre(),
                dto.getTipoDocumento(),
                dto.getNumDocumento(),
                dto.getGenero(),
                dto.getEdad(),
                dto.getNacimiento(),
                dto.getCelular(),
                dto.getEmail(),
                dto.getDepartamento(),
                dto.getCiudad(),
                dto.getDireccionResidencia(),
                dto.getEstrato(),
                dto.getReconocimiento(),
                dto.getDiscapacidad(),
                dto.getPoblacion(),
                dto.getNivelEducativo(),
                dto.getOcupacion(),
                dto.getUltimoTituloAcademico(),
                dto.getEstudioTrabajo(),
                dto.getSalario(),
                dto.getTiempoLibre());

        crearPerfilamiento(dto);

        return this.aspiranteRepository.save(nuevoAspirate);
    }


    public PerfilamientoAspirante crearPerfilamiento(AspiranteDTO dto){

        Aspirante aspirante = this.aspiranteRepository.findByEmail(dto.getEmail()).get();
        this.programadorReposiroty.save(new ValidadorDeTestGorilla(aspirante));

        if (dto.validarSiAplicaParaBeca(dto)){
            PerfilamientoAspirante becado = new PerfilamientoAspirante(aspirante,PerfilAspirante.BECADO,TipoDePerfilamiento.AUTOMATICO);
            return this.perfilamientoAspiranteRepository.save(becado);
        } else if (dto.validarSiAplicaParaComercial(dto)){
            PerfilamientoAspirante comercial = new PerfilamientoAspirante(aspirante,PerfilAspirante.COMERCIAL,TipoDePerfilamiento.AUTOMATICO);
            return this.perfilamientoAspiranteRepository.save(comercial);
        } else {
            PerfilamientoAspirante pendiente = new PerfilamientoAspirante(aspirante,PerfilAspirante.PENDIENTE,TipoDePerfilamiento.MANUAL);
            return this.perfilamientoAspiranteRepository.save(pendiente);
        }

    }

    public ResultadosTestGorillaResponseDTO leerResultados(String token, String assessmentID, String testTakerID) {
        String uri = baseUrl + assessmentID + "&candidature__test_taker=" + testTakerID;
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.buildAuthToken(token));
        ResponseEntity<ResultadosTestGorillaResponseDTO> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , ResultadosTestGorillaResponseDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Resultados del aspirante: {}", response.getBody());
            return response.getBody();
        }
        log.error("Error al obetener los resultados del aspirante - httpStatus was: {}", response.getStatusCode());
        throw new ApiException("Error no fue posible obtener los datos", HttpStatusCode.valueOf(400));
    }

    public ResponseEntity<String> actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla() {

        List<ValidadorDeTestGorilla> lista = StreamSupport.stream(this.programadorReposiroty.findByPruebaTerminada(false).spliterator(),false).toList();

        for (ValidadorDeTestGorilla p : lista){
            List<ResultadoDeAspiranteTestGorillaDTO> resultados = leerResultados("1234","3445",p.getAspirante().getIdAspirantePrueba()).getResultadosDeAspirante();

            boolean estadoPrueba = false;
            int totalPuntaje = 0;

            for (ResultadoDeAspiranteTestGorillaDTO r : resultados) {

                estadoPrueba = r.getCompletada().equals("true");
                if (!estadoPrueba) {
                    break;
                }
                totalPuntaje = (r.getPuntaje() != null) ? r.getPuntaje() + totalPuntaje : totalPuntaje;
            }

            boolean puntajePromedio = (totalPuntaje / 2) >= p.getPuntajePromedio();
            if (estadoPrueba && puntajePromedio) {
                p.setPruebaTerminada(true);
                this.programadorReposiroty.save(p);
            } else if (estadoPrueba){
                p.getAspirante().setEstadoAspirante(EstadoAspirante.DESCARTADO_PRUEBA_TESTGORILLA);
                this.aspiranteRepository.save(p.getAspirante());
                this.programadorReposiroty.delete(p);
            }
        }
        return new ResponseEntity<>("La lista ha sido actualizada", HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 8 * * *") // Ejecutar todos los días a las 8 AM
    public void validarTestGorillaAutomaticamenteYEnviarPublisher(){

        actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla();
        List<ValidadorDeTestGorilla> lista = StreamSupport.stream(this.programadorReposiroty.findByPruebaTerminada(true).spliterator(),false).toList();

        for (ValidadorDeTestGorilla p : lista){
            PerfilamientoAspirante perfil= this.perfilamientoAspiranteRepository.findByAspirante(p.getAspirante());

            if (perfil.getPerfilAspirante() != PerfilAspirante.PENDIENTE){
                PerfilamientoAspirannteDTO dto = new PerfilamientoAspirannteDTO(perfil.getAspirante().getId(),
                        perfil.getPerfilAspirante(),perfil.getTipoDePerfilamiento(),perfil.getResponsablePerfilarManual().getId());
                this.publisher.send(dto);
            }
        }
    }

    //Modificaciones

    public Aspirante modificarPrograma(Long idAspirante, Programa programa) {

        Aspirante aspirante = aspiranteRepository.findById(idAspirante).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );

        aspirante.setPrograma(programa);
        return aspiranteRepository.save(aspirante);
    }


    public Aspirante modificarCelular(Long id, Integer celular) {

        Aspirante aspirante = aspiranteRepository.findById(id).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );

        aspirante.setCelular(celular);
        return aspiranteRepository.save(aspirante);
    }

    public Aspirante modificarDireccionDeResidencia(Long id, String direccionResidencia) {

        Aspirante aspirante = aspiranteRepository.findById(id).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );

        aspirante.setDireccionResidencia(direccionResidencia);
        return aspiranteRepository.save(aspirante);
    }

    public PerfilamientoAspirante modificarPerfilAspirante(Long idAspirante, Long idResponsableDePerfilarManual,
                                                           PerfilAspirante nuevoPerfil) {

        Aspirante aspirante = aspiranteRepository.findById(idAspirante).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );
        Usuario usuario = this.usuarioRepository.findById(idResponsableDePerfilarManual).orElseThrow(
                () -> new ApiException("El usuario no existe")
        );

        PerfilamientoAspirante perfil = perfilamientoAspiranteRepository.findByAspirante(aspirante);

        perfil.setPerfilAspirante(nuevoPerfil);
        perfil.setResponsablePerfilarManual(usuario);
        perfil.setTipoDePerfilamiento(TipoDePerfilamiento.MANUAL);

        return this.perfilamientoAspiranteRepository.save(perfil);
    }

    //Listas

    public List<Aspirante> listarAspirantes() {
        return StreamSupport
                .stream(this.aspiranteRepository.findAll().spliterator(), false)
                .toList();
    }

    public List<Aspirante> listarAspirantesPorPrograma(Programa programa) {
        return StreamSupport
                .stream(this.aspiranteRepository.findByPrograma(programa).spliterator(), false)
                .toList();
    }

    public List<PerfilamientoAspirante> listarPorPerfil(PerfilAspirante perfilAspirante) {
        return StreamSupport
                .stream(this.perfilamientoAspiranteRepository.findByPerfilAspirante(perfilAspirante).spliterator(), false)
                .toList();
    }

    public List<PerfilamientoAspirante> listarPorTipoDePerfilamiento(TipoDePerfilamiento tipoDePerfilamiento) {
        return this.perfilamientoAspiranteRepository.findByTipoDePerfilamiento(tipoDePerfilamiento).stream()
                .toList();
    }










}
