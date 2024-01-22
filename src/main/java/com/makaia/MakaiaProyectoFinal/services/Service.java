package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadoDeAspiranteTestGorillaDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadosTestGorillaResponseDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.entities.Programador;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.publisher.Publisher;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@org.springframework.stereotype.Service
public class Service extends AbstractClient {

    private AspiranteRepository aspiranteRepository;
    private ProgramadorReposiroty programadorReposiroty;
    private PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;
    private Publisher publisher;


    @Autowired
    public Service(AspiranteRepository aspiranteRepository, ProgramadorReposiroty programadorReposiroty,
                   PerfilamientoAspiranteRepository perfilamientoAspiranteRepository, RestTemplate restTemplate) {
        super(restTemplate);
        this.aspiranteRepository = aspiranteRepository;
        this.programadorReposiroty = programadorReposiroty;
        this.perfilamientoAspiranteRepository = perfilamientoAspiranteRepository;
    }



    public PerfilamientoAspirante crearPerfilamiento(AspiranteDTO dto){

        Aspirante aspirante = this.aspiranteRepository.findByEmail(dto.getEmail()).get();
        this.programadorReposiroty.save(new Programador(aspirante));

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

    @Scheduled(fixedRate = 5184000) // Ejecutar cada 24 horas
    public void validarTestGorilla() {
        List<Programador> lista = StreamSupport.stream(this.programadorReposiroty.findAll().spliterator(), false).toList();
        for (Programador p : lista){
            List<ResultadoDeAspiranteTestGorillaDTO> resultados = leerResultados("1234","3445",p.getAspirante().getIdAspirantePrueba()).getResultadosDeAspirantes();
            int numeroDePruebasTerminadas = 0;
            for (ResultadoDeAspiranteTestGorillaDTO r : resultados){
                boolean estadoPrueba = r.getCompletada().equals("true");
                if (estadoPrueba){
                    int puntaje = Integer.parseInt(r.getPuntaje());
                    if (puntaje > 80){
                        numeroDePruebasTerminadas++;
                    }
                }
            }
            if (numeroDePruebasTerminadas == 2){
                p.setPruebaTerminada(true);
                this.programadorReposiroty.save(p);
            }
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





}
