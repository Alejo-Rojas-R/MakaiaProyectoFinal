package com.makaia.MakaiaProyectoFinal.entities;


import com.makaia.MakaiaProyectoFinal.enums.Estado;
import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @OneToOne
    @JoinColumn(name = "aspirante_id", unique = true)
    private Aspirante aspirante;

    @Enumerated(EnumType.ORDINAL)
    private Estado estado;

    public Perfil() {
    }

    public Perfil(Aspirante aspirante, Estado estado) {
        this.aspirante = aspirante;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
