package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.entities.PerfilamientoAspirante;
import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import com.makaia.MakaiaProyectoFinal.enums.Programa;
import com.makaia.MakaiaProyectoFinal.enums.TipoDePerfilamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilamientoAspiranteRepository extends JpaRepository<PerfilamientoAspirante, Long> {

    @Query
    PerfilamientoAspirante findByAspirante(Aspirante aspirante);

    @Query
    List<PerfilamientoAspirante> findByPerfilAspirante(PerfilAspirante perfilAspirante);

    @Query
    List<PerfilamientoAspirante> findByTipoDePerfilamiento(TipoDePerfilamiento tipoDePerfilamiento);
}
