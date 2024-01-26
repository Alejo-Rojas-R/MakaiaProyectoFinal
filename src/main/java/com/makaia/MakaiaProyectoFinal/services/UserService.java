package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.LoginResponseDTO;
import com.makaia.MakaiaProyectoFinal.dtos.ResponseErrorDTO;
import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.Rol;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import com.makaia.MakaiaProyectoFinal.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

@Service
public class UserService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @Autowired
    public UserService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
/*
    public Usuario createUser(UsuarioDTO dto) {
        boolean exists = this.userRepository.findByEmail(dto.getEmail()).isPresent();
        if (exists) {
            throw new ApiException("Este correo ya esta en uso", HttpStatus.NOT_FOUND);
        }

        String encryptedPassword = passwordEncoder.encode(dto.getContrasena());

        Usuario newUser = new Usuario(
                dto.getEmail(),
                encryptedPassword,
                Rol.USER);
        return this.userRepository.save(newUser);
    }
*/

    public Usuario createUser(UsuarioDTO dto) {
        boolean exists = this.userRepository.findByEmail(dto.getEmail()).isPresent();
        if (exists) {
            throw new ApiException("Este correo ya esta en uso", HttpStatus.NOT_FOUND);
        }

        String encryptedPassword = passwordEncoder.encode(dto.getContrasena());

        Usuario newUser = new Usuario(
                dto.getEmail(),
                encryptedPassword,
                Rol.USER);
        return this.userRepository.save(newUser);
    }

    public ResponseEntity login(UsuarioDTO dto) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getContrasena()));

            String encryptedPassword = passwordEncoder.encode(dto.getContrasena());
            String email = authentication.getName();

            Usuario newUser = new Usuario(
                    dto.getEmail(),
                    encryptedPassword,
                    Rol.USER);

            String token = jwtUtil.createToken(newUser);
            LoginResponseDTO loginRes = new LoginResponseDTO(email, token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e) {
            ResponseErrorDTO errorResponse = new ResponseErrorDTO("Invalid username or password", 400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ResponseErrorDTO errorResponse = new ResponseErrorDTO(e.getMessage(), 400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}