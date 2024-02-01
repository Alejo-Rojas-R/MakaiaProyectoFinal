package com.makaia.MakaiaProyectoFinal.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.makaia.MakaiaProyectoFinal.dtos.LoginResponseDTO;
import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.Rol;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import com.makaia.MakaiaProyectoFinal.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceTest{

    @Mock
    private UsuarioRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwtUtil;
    @InjectMocks
    private UserService userService;
    private UsuarioDTO userDto;
    private Usuario user;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userDto = new UsuarioDTO();
        userDto.setEmail("test@example.com");
        userDto.setContrasena("password");

        user = new Usuario(userDto.getEmail(), passwordEncoder.encode(userDto.getContrasena()), Rol.USER);

    }

    @Test
    void createUser_Success() {
        // Arrange
        UsuarioDTO dto = new UsuarioDTO("test@test.com", "password", null);
        Usuario user = new Usuario(dto.getEmail(), dto.getContrasena(), Rol.USER);
        when(userRepository.findByEmail(dto.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(Usuario.class))).thenReturn(user);
        when(passwordEncoder.encode(any())).thenReturn("encryptedPassword");

        // Act
        Usuario result = userService.createUser(dto);

        // Assert
        assertEquals(result.getEmail(), dto.getEmail());
    }

    @Test
    void createUser_UserAlreadyExists() {
        // Arrange
        UsuarioDTO dto = new UsuarioDTO("existing@test.com", "password",null);
        when(userRepository.findByEmail(dto.getEmail())).thenReturn(Optional.of(new Usuario()));

        // Act & Assert
        ApiException thrown = assertThrows(
                ApiException.class,
                () -> userService.createUser(dto)
        );
        assertEquals(HttpStatus.NOT_FOUND, thrown.getCode());
    }
    @Test
void login_AuthenticationSucceeds_TokenAndUserReturned() {
    when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(mock(Authentication.class));
    when(jwtUtil.createToken(any(Usuario.class))).thenReturn("token");
    when(passwordEncoder.encode(anyString())).thenReturn("EncryptedPassword");

    ResponseEntity responseEntity = userService.login(userDto);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    verify(jwtUtil).createToken(any(Usuario.class));
}

    @Test
    void login_BadCredentials() {
        // Arrange
        UsuarioDTO dto = new UsuarioDTO("test@test.com", "password",null);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Invalid username or password"));

        // Act
        ResponseEntity responseEntity = userService.login(dto);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void login_OtherException() {
        // Arrange
        UsuarioDTO dto = new UsuarioDTO("test@test.com", "password", null);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new RuntimeException("Some exception"));

        // Act
        ResponseEntity responseEntity = userService.login(dto);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
