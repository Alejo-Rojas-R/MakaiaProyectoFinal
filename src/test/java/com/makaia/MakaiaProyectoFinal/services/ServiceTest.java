package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadosTestGorillaResponseDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.publisher.Publisher;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class ServiceTest {

    private static final String baseUrl = "http://test.gorilla/api/";

    @Mock
    private AspiranteRepository aspiranteRepository;

    @Mock
    private ProgramadorReposiroty programadorReposiroty;

    @Mock
    private PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;

    @Mock
    private Publisher publisher;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Service service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ApiException.class)
    public void testCrearAspirante_ConAspiranteYaExistente() {
        //  Arrange
        AspiranteDTO dto = mock(AspiranteDTO.class);
        Optional<Aspirante> optAspirante = Optional.of(new Aspirante());
        when(dto.getEmail()).thenReturn("existing@example.com");
        when(aspiranteRepository.findByEmail(anyString())).thenReturn(optAspirante);

        // Action
        service.crearAspirante(dto);

        // Assert
        verify(aspiranteRepository, never()).save(any(Aspirante.class));
    }
    @Test
    public void testCrearPerfilamiento() {
        //  Arrange
        AspiranteDTO dto = mock(AspiranteDTO.class);
        Aspirante aspirante = new Aspirante();
        PerfilamientoAspirante perfilamiento = new PerfilamientoAspirante();
        when(dto.getEmail()).thenReturn("email@example.com");
        when(aspiranteRepository.findByEmail(anyString())).thenReturn(Optional.of(aspirante));
        when(perfilamientoAspiranteRepository.save(any(PerfilamientoAspirante.class))).thenReturn(perfilamiento);

        // Action
        PerfilamientoAspirante resultPerfilamiento = service.crearPerfilamiento(dto);

        // Assert
        assertNotNull(resultPerfilamiento);
        verify(perfilamientoAspiranteRepository).save(any(PerfilamientoAspirante.class));
    }

    @Test
    public void testLeerResultados_Success() {
        // Arrange
        String token = "1234";
        String assessmentID = "3445";
        String testTakerID = "67890";
        ResultadosTestGorillaResponseDTO mockResponseDto = mock(ResultadosTestGorillaResponseDTO.class);
        ResponseEntity<ResultadosTestGorillaResponseDTO> responseEntity = new ResponseEntity<>(mockResponseDto, HttpStatus.OK);
        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                eq(ResultadosTestGorillaResponseDTO.class)))
                .thenReturn(responseEntity);

        // Action
        ResultadosTestGorillaResponseDTO result = service.leerResultados(token, assessmentID, testTakerID);

        // Assert
        assertEquals(mockResponseDto, result);
    }

}
