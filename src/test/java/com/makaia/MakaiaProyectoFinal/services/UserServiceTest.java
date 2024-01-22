package com.makaia.MakaiaProyectoFinal.services;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.Rol;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;
    private UsuarioDTO usuarioDTO;

    @Before
    public void setUp() {
        usuarioDTO = new UsuarioDTO();
    }
    @Test
    public void createUser_Successful() {
        // Arrenge
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail("test@test.com");
        dto.setContrasena("password");
        when(usuarioRepository.findByEmail(dto.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(dto.getContrasena())).thenReturn("encryptedPassword");
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Usuario createdUser = userService.createUser(dto);

        // Assert
        assertNotNull(createdUser);
        assertEquals(dto.getEmail(), createdUser.getEmail());
        assertEquals("encryptedPassword", createdUser.getContrasena());
        assertEquals(Rol.USER, createdUser.getRol());
    }
    @Test
    public void createUser_ExistingEmail_ThrowsApiException() {
        // Arrenge
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail("existing@test.com");
        dto.setContrasena("password");
        when(usuarioRepository.findByEmail(dto.getEmail())).thenReturn(Optional.of(new Usuario()));

        // Act
        ApiException exception = assertThrows(ApiException.class, () -> {
            userService.createUser(dto);
        });

        // Assert
        assertEquals("Este correo ya esta en uso", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getCode());
    }

}
