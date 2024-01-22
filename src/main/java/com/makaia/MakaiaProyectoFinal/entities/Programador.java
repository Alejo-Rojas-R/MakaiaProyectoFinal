package com.makaia.MakaiaProyectoFinal.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "programador")
public class Programador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private int tiempo ;

    @OneToOne
    @JoinColumn(name = "aspirante_id",unique = true)
    private Aspirante aspirante ;

    @Column(nullable = false)
    private boolean pruebaTerminada = false;

    public Programador() {
    }

    public Programador(Aspirante aspirante) {
        this.aspirante = aspirante;
    }


    public void setPruebaTerminada(boolean pruebaTerminada) {
        this.pruebaTerminada = pruebaTerminada;
    }

}
