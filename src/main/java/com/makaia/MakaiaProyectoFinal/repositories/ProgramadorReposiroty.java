package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.ValidadorDeTestGorilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramadorReposiroty extends JpaRepository<ValidadorDeTestGorilla, Long> {
    @Query
    List<ValidadorDeTestGorilla> findByPruebaTerminada(boolean pruebaTerminada);
}
