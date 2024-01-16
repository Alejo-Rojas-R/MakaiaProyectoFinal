package com.makaia.MakaiaProyectoFinal.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.Rol;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

class UserServiceTest {

    @Mock
    private UsuarioRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(passwordEncoder.encode(anyString())).thenReturn("hashedPassword");
    }

    @Test
    void createUser_UserAlreadyExists() {
        // Arrenge
        UsuarioDTO userDTO = new UsuarioDTO("test@example.com", "password",Rol.GESTOR);
        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(java.util.Optional.of(new Usuario()));

        // Action
        ApiException apiException = assertThrows(ApiException.class, () -> userService.createUser(userDTO));
        assertEquals("Este correo ya esta en uso", apiException.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, apiException.getCode());

        // Assert
        verify(userRepository, never()).save(any());
    }
}
