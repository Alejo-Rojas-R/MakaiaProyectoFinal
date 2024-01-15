package com.makaia.MakaiaProyectoFinal.services;

import com.makaia.MakaiaProyectoFinal.dtos.UsuarioDTO;
import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.enums.Rol;
import com.makaia.MakaiaProyectoFinal.exceptions.ApiException;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

@Service
public class UserService {
    private final UsuarioRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
}