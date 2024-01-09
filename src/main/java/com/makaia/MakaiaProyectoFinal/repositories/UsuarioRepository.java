package com.makaia.MakaiaProyectoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
