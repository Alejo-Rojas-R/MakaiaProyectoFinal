package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResultadosTestGorillaResponseDTO;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import com.makaia.MakaiaProyectoFinal.enums.Programa;
import com.makaia.MakaiaProyectoFinal.enums.TipoDePerfilamiento;
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

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void ejecutarTestModificarProgramaConIdValido() {
        testModificarProgramaConIdValido();
    }
    private void testModificarProgramaConIdValido() {
        Aspirante mockAspirante = new Aspirante();
        Programa mockPrograma = Programa.BACK_END;
        when(aspiranteRepository.findById(any())).thenReturn(Optional.of(mockAspirante));
        when(aspiranteRepository.save(any(Aspirante.class))).thenReturn(mockAspirante);

        Aspirante result = service.modificarPrograma(1L, mockPrograma);

        assertNotNull(result);
        assertEquals(mockPrograma, result.getPrograma());
        verify(aspiranteRepository).save(mockAspirante);
    }
    @Test
    public void ejecutarModificarCelularAspirante() {
        testModificarCelularAspirante();
    }
    private void testModificarCelularAspirante() {
        Long id = 1L;
        Integer nuevoCelular = 987654321;
        Aspirante aspirante = new Aspirante();
        when(aspiranteRepository.findById(id)).thenReturn(Optional.of(aspirante));
        when(aspiranteRepository.save(aspirante)).thenReturn(aspirante);

        Aspirante updated = service.modificarCelular(id, nuevoCelular);

        assertEquals(nuevoCelular, updated.getCelular());
        verify(aspiranteRepository).save(aspirante);
    }
    @Test
    public void ejecutarTestModificarCelular_aspiranteNoExistente() {
        testModificarCelular_aspiranteNoExistente();
    }
    void testModificarCelular_aspiranteNoExistente() {
        // Arrange
        when(aspiranteRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        ApiException thrown = assertThrows(ApiException.class, () -> service.modificarCelular(1L, 123456789));
        assertEquals("El aspirante no existe", thrown.getMessage());
    }
    @Test
    public void ejecutarTestModificarProgramaConIdInvalido() {
        testModificarProgramaConIdInvalido();
    }
    private void testModificarProgramaConIdInvalido() {
        when(aspiranteRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ApiException.class, () -> service.modificarPrograma(99L,Programa.CLOUD));
    }
    @Test
    public void ejecutarTestModificarDireccionAspirante() {
        testModificarDireccionAspirante();
    }
    void testModificarDireccionAspirante() {
        Long id = 1L;
        String nuevaDireccion = "New Address";
        Aspirante aspirante = new Aspirante();
        when(aspiranteRepository.findById(id)).thenReturn(Optional.of(aspirante));
        when(aspiranteRepository.save(aspirante)).thenReturn(aspirante);

        Aspirante updated = service.modificarDireccionDeResidencia(id, nuevaDireccion);

        assertEquals(nuevaDireccion, updated.getDireccionResidencia());
        verify(aspiranteRepository).save(aspirante);
    }
    @Test
    public void ejecutarTestModificarDireccionDeResidencia_aspiranteNoExistente() {
        testModificarDireccionDeResidencia_aspiranteNoExistente();
    }
    private void testModificarDireccionDeResidencia_aspiranteNoExistente() {
        // Arrange
        when(aspiranteRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        ApiException thrown = assertThrows(ApiException.class, () -> service.modificarDireccionDeResidencia(1L, "New Address"));
        assertEquals("El aspirante no existe", thrown.getMessage());
    }
    @Test
    public void ejecutarTestModificarPerfilAspirante() {
        testModificarPerfilAspirante();
    }
    private void testModificarPerfilAspirante() {
        Long idAspirante = 1L;
        Long idResponsable = 1L;
        PerfilAspirante nuevoPerfil = PerfilAspirante.BECADO;
        Aspirante aspirante = new Aspirante();
        Usuario usuario = new Usuario();
        PerfilamientoAspirante perfilamientoAspirante = new PerfilamientoAspirante();
        perfilamientoAspirante.setTipoDePerfilamiento(TipoDePerfilamiento.MANUAL);
        perfilamientoAspirante.setResponsablePerfilarManual(usuario);
        perfilamientoAspirante.setPerfilAspirante(PerfilAspirante.PENDIENTE);

        when(aspiranteRepository.findById(idAspirante)).thenReturn(Optional.of(aspirante));
        when(usuarioRepository.findById(idResponsable)).thenReturn(Optional.of(usuario));
        when(perfilamientoAspiranteRepository.findByAspirante(aspirante)).thenReturn(perfilamientoAspirante);
        when(perfilamientoAspiranteRepository.save(perfilamientoAspirante)).thenReturn(perfilamientoAspirante);

        PerfilamientoAspirante updated = service.modificarPerfilAspirante(idAspirante, idResponsable, nuevoPerfil);

        assertSame(nuevoPerfil, updated.getPerfilAspirante());
        assertSame(usuario, updated.getResponsablePerfilarManual());
        assertEquals(TipoDePerfilamiento.MANUAL, updated.getTipoDePerfilamiento());
        verify(perfilamientoAspiranteRepository).save(perfilamientoAspirante);
    }
    @Test
    public void ejecutarTestModificarPerfilAspirante_aspiranteNoExistente() {
        testModificarPerfilAspirante_aspiranteNoExistente();
    }
   private void testModificarPerfilAspirante_aspiranteNoExistente() {
        // Arrange
        when(aspiranteRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        ApiException thrown = assertThrows(ApiException.class, () -> service.modificarPerfilAspirante(1L, 1L, PerfilAspirante.COMERCIAL));
        assertEquals("El aspirante no existe", thrown.getMessage());
    }
    @Test
    public void ejecutarTestModificarPerfilAspiranteUsuarioNoExistente() {
        testModificarPerfilAspiranteUsuarioNoExistente();
    }
   private void testModificarPerfilAspiranteUsuarioNoExistente() {
        // Arrange
        Aspirante aspirante = new Aspirante();
        aspirante.setId(1L);
        when(aspiranteRepository.findById(aspirante.getId())).thenReturn(Optional.of(aspirante));
        when(usuarioRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        ApiException thrown = assertThrows(ApiException.class, () -> service.modificarPerfilAspirante(aspirante.getId(), 1L, PerfilAspirante.BECADO));
        assertEquals("El usuario no existe", thrown.getMessage());
    }
    @Test
    public void ejecutarTestListarAspirantes() {
        testListarAspirantes();
    }
    private void testListarAspirantes() {
        List<Aspirante> mockAspirantes = new ArrayList<>();
        mockAspirantes.add(new Aspirante());
        when(aspiranteRepository.findAll()).thenReturn(mockAspirantes);

        List<Aspirante> result = service.listarAspirantes();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    @Test
    public void ejecutarTestlistarAspirantesPorPrograma() {
        testlistarAspirantesPorPrograma();
    }
    private void testlistarAspirantesPorPrograma() {
        // Arrange
        Aspirante aspirante = new Aspirante();
        when(aspiranteRepository.findByPrograma(any())).thenReturn(Arrays.asList(aspirante));

        // Act
        List<Aspirante> aspirantes = service.listarAspirantesPorPrograma(Programa.ANALISIS_DATOS);

        // Assert
        assertFalse(aspirantes.isEmpty());
        assertTrue(aspirantes.contains(aspirante));
    }
    @Test
    public void ejecutarTestlistarPorPerfil_debeDevolverListaPorPerfil(){
        testlistarPorPerfil_debeDevolverListaPorPerfil();
    }
    private void testlistarPorPerfil_debeDevolverListaPorPerfil() {

        // Arrange
        PerfilamientoAspirante perfilamientoAspirante = new PerfilamientoAspirante();
        when(perfilamientoAspiranteRepository.findByPerfilAspirante(any())).thenReturn(Arrays.asList(perfilamientoAspirante));

        // Act
        List<PerfilamientoAspirante> perfilamientos = (List<PerfilamientoAspirante>) service.listarPorPerfil(PerfilAspirante.PENDIENTE);

        // Assert
        assertFalse(perfilamientos.isEmpty());
        assertTrue(perfilamientos.contains(perfilamientoAspirante));
    }
    @Test
    public void ejecutarTestlistarPorTipoDePerfilamiento_debeDevolverListaDePerfilamientos(){
        testlistarPorTipoDePerfilamiento_debeDevolverListaDePerfilamientos();
    }
    private void testlistarPorTipoDePerfilamiento_debeDevolverListaDePerfilamientos() {
        // Arrange
        PerfilamientoAspirante perfilamientoAspirante = new PerfilamientoAspirante();
        when(perfilamientoAspiranteRepository.findByTipoDePerfilamiento(any())).thenReturn(Collections.singletonList(perfilamientoAspirante));

        // Act
        List<PerfilamientoAspirante> perfilamientos = service.listarPorTipoDePerfilamiento(TipoDePerfilamiento.MANUAL);

        // Assert
        assertFalse(perfilamientos.isEmpty());
        assertTrue(perfilamientos.contains(perfilamientoAspirante));
    }

}
