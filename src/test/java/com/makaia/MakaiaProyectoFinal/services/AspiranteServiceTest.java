package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.*;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.AspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.PerfilamientoAspiranteRepository;
import com.makaia.MakaiaProyectoFinal.repositories.ProgramadorReposiroty;
import com.makaia.MakaiaProyectoFinal.services.AspiranteService;
import com.makaia.MakaiaProyectoFinal.dtos.AspiranteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AspiranteServiceTest {
    @Mock
    private AspiranteRepository aspiranteRepository;
    @Mock
    private ProgramadorReposiroty programadorReposiroty;
    @Mock
    private PerfilamientoAspiranteRepository perfilamientoAspiranteRepository;

    @InjectMocks
    private AspiranteService aspiranteService;

    private Aspirante aspirante;
    private AspiranteDTO aspiranteDTO;
    private Programa programa;

    @BeforeEach
    void setUp() {
        programa = Programa.ANALISIS_DATOS;
        Date nacimiento = new GregorianCalendar(1999, Calendar.JANUARY, 1).getTime();

        aspirante = new Aspirante();
        aspirante.setId(1L);
        aspirante.setPrograma(programa);
        aspirante.setNombre("Juan Perez");
        aspirante.setTipoDocumento(TipoDocumento.CEDULA_DE_CIUDADANIA);
        aspirante.setNumDocumento(12345678);
        aspirante.setGenero(Genero.HOMBRE);
        aspirante.setEdad(30);
        aspirante.setNacimiento(nacimiento);
        aspirante.setCelular(300123456);
        aspirante.setEmail("juan.perez@example.com");
        aspirante.setDepartamento(Departamento.ANTIOQUIA);
        aspirante.setCiudad("Medellín");
        aspirante.setDireccionResidencia("Calle 10 # 20-30");
        aspirante.setEstrato(Estrato.CUATRO);
        aspirante.setReconocimiento(Reconocimiento.GITANO_O_RROM);
        aspirante.setDiscapacidad(Discapacidad.NINGUNA);
        aspirante.setPoblacion(Poblacion.DESPLAZADO);
        aspirante.setNivelEducativo(NivelEducativo.BACHILLERATO);
        aspirante.setOcupacion(Ocupacion.ESTUDIO);
        aspirante.setUltimoTituloAcademico("Ingeniero de Sistemas");
        aspirante.setEstudioTrabajo("Sí");
        aspirante.setSalario(Salario.MAS_SALARIO_MINIMO);
        aspirante.setTiempoLibre("Jugar videojuegos");

        aspiranteDTO = new AspiranteDTO();
        aspiranteDTO.setId(aspirante.getId());
    }

    @Test
    void crearAspirante_shouldCreateAspirante() {
        // Arrange
        when(aspiranteRepository.save(any(Aspirante.class))).thenReturn(aspirante);

        // Act
        Aspirante createdAspirante = aspiranteService.crearAspirante(
                aspirante.getId(),
                aspirante.getPrograma(),
                aspirante.getNombre(),
                aspirante.getTipoDocumento(),
                aspirante.getNumDocumento(),
                aspirante.getGenero(),
                aspirante.getEdad(),
                aspirante.getNacimiento(),
                aspirante.getCelular(),
                aspirante.getEmail(),
                aspirante.getDepartamento(),
                aspirante.getCiudad(),
                aspirante.getDireccionResidencia(),
                aspirante.getEstrato(),
                aspirante.getReconocimiento(),
                aspirante.getDiscapacidad(),
                aspirante.getPoblacion(),
                aspirante.getNivelEducativo(),
                aspirante.getOcupacion(),
                aspirante.getUltimoTituloAcademico(),
                aspirante.getEstudioTrabajo(),
                aspirante.getSalario(),
                aspirante.getTiempoLibre()
        );

        // Assert
        assertNotNull(createdAspirante);
        assertEquals(30, createdAspirante.getEdad());
        verify(aspiranteRepository).save(createdAspirante);
    }

    @Test
    void asignarPrograma_shouldThrowExceptionIfProgramaIsNull() {
        //Arrange
        Programa programa = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> aspiranteService.asignarPrograma(aspiranteDTO, programa));
    }

    @Test
    void asignarPrograma_shouldAssignProgramaToAspirante() {
        // Arrange
        Programa newPrograma = Programa.CLOUD;
        when(aspiranteRepository.findById(aspiranteDTO.getId())).thenReturn(Optional.of(aspirante));
        when(aspiranteRepository.save(any(Aspirante.class))).thenReturn(aspirante);

        // Act
        Programa assignedPrograma = aspiranteService.asignarPrograma(aspiranteDTO, newPrograma);

        // Assert
        assertEquals(newPrograma, assignedPrograma);
        verify(aspiranteRepository).save(any(Aspirante.class));
    }

    @Test
    void asignarPrograma_shouldThrowApiExceptionWhenAspiranteDoesNotExist() {
        // Arrange
        when(aspiranteRepository.findById(aspiranteDTO.getId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ApiException.class,
                () -> aspiranteService.asignarPrograma(aspiranteDTO, programa));
    }

@Test
void editarPrograma_shouldEditProgramaOfAspirante() {
    // Arrange
    Programa newPrograma = Programa.CLOUD;
    when(aspiranteRepository.findById(aspirante.getId())).thenReturn(Optional.of(aspirante));
    when(aspiranteRepository.save(any(Aspirante.class))).thenReturn(aspirante); // Agrega esta línea

    // Act
    Aspirante updatedAspirante = aspiranteService.editarPrograma(aspirante.getId(), newPrograma);

    // Assert
    assertNotNull(updatedAspirante, "El objeto updatedAspirante no debería ser nulo");
    assertEquals(newPrograma, updatedAspirante.getPrograma());
    verify(aspiranteRepository).save(any(Aspirante.class));
}

    @Test
    void editarPrograma_shouldThrowApiExceptionWhenAspiranteDoesNotExist() {
        // Arrange
        when(aspiranteRepository.findById(aspirante.getId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ApiException.class,
                () -> aspiranteService.editarPrograma(aspirante.getId(), programa));
    }

    @Test
    void listarAspirantes_shouldReturnListOfAspirantes() {
        // Arrange
        List<Aspirante> aspirantes = Arrays.asList(aspirante);
        when(aspiranteRepository.findAll()).thenReturn(aspirantes);

        // Act
        List<Aspirante> retrievedAspirantes = aspiranteService.listarAspirantes();

        // Assert
        assertFalse(retrievedAspirantes.isEmpty());
        assertEquals(1, retrievedAspirantes.size());
        assertTrue(retrievedAspirantes.contains(aspirante));
    }
}
