package com.makaia.MakaiaProyectoFinal.security;

import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import com.makaia.MakaiaProyectoFinal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CustomDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = this.usuarioRepository.findByEmail(username);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no registrado");
        }

        UserDetails loggedUser = User
                .withUsername(user.get().getEmail())
                .password(user.get().getPassword())
                .roles(String.valueOf(user.get().getRol()))
                .build();

        return loggedUser;
    }
}