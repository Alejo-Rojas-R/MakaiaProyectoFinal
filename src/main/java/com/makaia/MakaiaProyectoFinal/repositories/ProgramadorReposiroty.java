package com.makaia.MakaiaProyectoFinal.repositories;

import com.makaia.MakaiaProyectoFinal.entities.Programador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorReposiroty extends JpaRepository<Programador, Long> {
}
