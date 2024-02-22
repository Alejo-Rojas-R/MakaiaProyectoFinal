package com.makaia.MakaiaProyectoFinal.repositories;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {

    @Query
    Optional<Aspirante> findByEmail(String email);

    @Query("SELECT a FROM Aspirante a WHERE CAST(a.numDocumento AS string) LIKE :documento%")
    List<Aspirante> findByNumDocumentoGreaterThanEqual(@Param("documento") String documento);

    @Query
    List<Aspirante> findByPrograma(Programa programa);

}
