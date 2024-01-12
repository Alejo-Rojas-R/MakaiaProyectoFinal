package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilamientoAspirante, Long> {
}
