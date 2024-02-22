package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.*;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.entities.ValidadorDeTestGorilla;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.publisher.Publisher;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorRepository;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.lang.reflect.Field;

@Slf4j
@org.springframework.stereotype.Service
public class Service extends AbstractClient {

    private AspiranteRepository aspiranteRepository;
    private ProgramadorRepository programadorRepository;
    private PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;
    private Publisher publisher;
    private UsuarioRepository usuarioRepository;


    @Autowired
    public Service(AspiranteRepository aspiranteRepository, ProgramadorRepository programadorRepository,
                   PerfilamientoAspiranteRepository perfilamientoAspiranteRepository, RestTemplate restTemplate, Publisher publisher, UsuarioRepository usuarioRepository) {
        super(restTemplate);
        this.aspiranteRepository = aspiranteRepository;
        this.programadorRepository = programadorRepository;
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

        this.aspiranteRepository.save(nuevoAspirate);

        crearPerfilamiento(dto);

        return nuevoAspirate;
    }


    public PerfilamientoAspirante crearPerfilamiento(AspiranteDTO dto){

        Aspirante aspirante = this.aspiranteRepository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );
        this.programadorRepository.save(new ValidadorDeTestGorilla(aspirante));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Usuario usuario = this.usuarioRepository.findByEmail(authentication.getName()).orElseThrow(
            () -> new ApiException("El usuario no existe")
        );

        if (dto.validarSiAplicaParaBeca(dto)){
            PerfilamientoAspirante becado = new PerfilamientoAspirante(aspirante,PerfilAspirante.BECADO,TipoDePerfilamiento.AUTOMATICO, usuario);
            return this.perfilamientoAspiranteRepository.save(becado);
        } else if (dto.validarSiAplicaParaComercial(dto)){
            PerfilamientoAspirante comercial = new PerfilamientoAspirante(aspirante,PerfilAspirante.COMERCIAL,TipoDePerfilamiento.AUTOMATICO, usuario);
            return this.perfilamientoAspiranteRepository.save(comercial);
        } else {
            PerfilamientoAspirante pendiente = new PerfilamientoAspirante(aspirante,PerfilAspirante.PENDIENTE,TipoDePerfilamiento.MANUAL, usuario);
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

        List<ValidadorDeTestGorilla> lista = StreamSupport.stream(this.programadorRepository.findByPruebaTerminada(false).spliterator(),false).toList();

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
                this.programadorRepository.save(p);
            } else if (estadoPrueba){
                p.getAspirante().setEstadoAspirante(EstadoAspirante.DESCARTADO_PRUEBA_TESTGORILLA);
                this.aspiranteRepository.save(p.getAspirante());
                this.programadorRepository.delete(p);
            }
        }
        return new ResponseEntity<>("La lista ha sido actualizada", HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 8 * * *") // Ejecutar todos los días a las 8 AM
    public void validarTestGorillaAutomaticamenteYEnviarPublisher(){

        actualizarListaDePruebasPendientesPorFinalizarDeTestGorilla();
        List<ValidadorDeTestGorilla> lista = StreamSupport.stream(this.programadorRepository.findByPruebaTerminada(true).spliterator(),false).toList();

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

    public Aspirante modificarAspirante(Long id, AspiranteDTO dto) {
        Aspirante aspirante = this.aspiranteRepository.findById(id).orElseThrow(
                () -> new ApiException("El aspirante no existe", HttpStatus.NOT_FOUND)
        );

        Field[] fields = dto.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(dto);
                if (value != null) {
                    Field aspiranteField = Aspirante.class.getDeclaredField(field.getName());
                    aspiranteField.setAccessible(true);
                    aspiranteField.set(aspirante, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.aspiranteRepository.save(aspirante);

        return aspirante;
    }

    public PerfilamientoAspirante modificarPerfilAspirante(Long idAspirante, Long idResponsableDePerfilarManual,
                                                           PerfilAspirante nuevoPerfil) {

        Aspirante aspirante = aspiranteRepository.findById(idAspirante).orElseThrow(
                () -> new ApiException("El aspirante no existe")
        );

        Object user = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

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


    public Aspirante leerAspirante(Long idAspirante) {
        Aspirante aspirante = this.aspiranteRepository.findById(idAspirante).orElseThrow(
            () -> new ApiException("El aspirante no existe", HttpStatus.NOT_FOUND)
        );

        return aspirante;
    }

    public List<Aspirante> listarPorDocumento(String documento) {
        return StreamSupport
            .stream(this.aspiranteRepository.findByNumDocumentoGreaterThanEqual(documento).spliterator(), false)
            .toList();
    }

    public ResponseEntity<String> eliminarAspirante(Long id) {
        Aspirante aspirante = this.aspiranteRepository.findById(id).orElseThrow(
                () -> new ApiException("El aspirante no existe", HttpStatus.NOT_FOUND)
        );

        this.aspiranteRepository.delete(aspirante);

        if (this.aspiranteRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El aspirante con numero de documento " +aspirante.getNumDocumento() + ", no pudo ser eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("El aspirante con numero de documento " + aspirante.getNumDocumento() + ", fue eliminado existosamente");
        }
    }
}
