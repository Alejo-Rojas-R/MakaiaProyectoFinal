package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilamientoAspiranteRepository extends JpaRepository<PerfilamientoAspirante, Long> {
}
