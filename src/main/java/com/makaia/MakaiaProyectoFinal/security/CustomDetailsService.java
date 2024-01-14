package com.makaia.MakaiaProyectoFinal.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class CustomDetailsService implements UserDetailsService {
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Agregar lógica para llamar a la bas de datos con el nombre de usuario.
        // Usuario user = this.userRepository.findByUsername(username);

        if (!username.equals("Lugel")) {
            throw new UsernameNotFoundException("Usuario " + username + " no existe en la base de datos");
        }

        return User.withUsername(username)
                // Cuando consulten de base de datos no encripten dos veces
                .password(passwordEncoder().encode(username))
                .roles("ADMIN")
                .build();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}


