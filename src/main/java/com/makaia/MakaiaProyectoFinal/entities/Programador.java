package com.makaia.MakaiaProyectoFinal.entities;

import jakarta.persistence.*;

@Entity
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

    @Column
    private boolean pruebaTerminada ;

    public Programador() {
    }

    public Programador(int tiempo, Aspirante aspirante, boolean pruebaTerminada) {
        this.tiempo = tiempo;
        this.aspirante = aspirante;
        this.pruebaTerminada = pruebaTerminada;
    }

    public Long getId() {
        return id;
    }

    public int getTiempo() {
        return tiempo;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public boolean isPruebaTerminada() {
        return pruebaTerminada;
    }
}
