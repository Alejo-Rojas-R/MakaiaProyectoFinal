package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query
    Optional<Usuario> findByEmail(String email);
}
