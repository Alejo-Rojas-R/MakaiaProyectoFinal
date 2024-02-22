package com.makaia.MakaiaProyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "programador")
public class ValidadorDeTestGorilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aspirante_id",unique = true)
    private Aspirante aspirante ;

    @Column(nullable = false)
    private boolean pruebaTerminada = false;

    @Column(nullable = false)
    private Integer puntajePromedio = 70;

    public ValidadorDeTestGorilla() {
    }

    public ValidadorDeTestGorilla(Aspirante aspirante) {
        this.aspirante = aspirante;
    }


    public void setPruebaTerminada(boolean pruebaTerminada) {
        this.pruebaTerminada = pruebaTerminada;
    }
}
