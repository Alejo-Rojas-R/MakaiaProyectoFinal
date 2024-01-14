package com.makaia.MakaiaProyectoFinal.repositories;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
    @Query
    public Aspirante findById(long id);

}
