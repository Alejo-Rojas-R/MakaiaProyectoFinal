package com.makaia.MakaiaProyectoFinal.entities;


import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "perfilamientoAspirante")
public class PerfilamientoAspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @OneToOne
    @JoinColumn(name = "aspirante_id", unique = true)
    private Aspirante aspirante;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private PerfilAspirante perfilAspirante;

    @Column(length = 50, nullable = false)
    private String tipoDePerfilamiento;

    @ManyToOne
    private Usuario responsablePerfilarManual;

    public PerfilamientoAspirante() {
    }

    public PerfilamientoAspirante(Aspirante aspirante, @NotNull PerfilAspirante perfilAspirante,
                                  String tipoDePerfilamiento, Usuario responsablePerfilarManual) {
        this.aspirante = aspirante;
        this.perfilAspirante = perfilAspirante;
        this.tipoDePerfilamiento = tipoDePerfilamiento;
        this.responsablePerfilarManual = responsablePerfilarManual;
    }

    public Long getId() {
        return id;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public PerfilAspirante getPerfilAspirante() {
        return perfilAspirante;
    }

    public String getTipoDePerfilamiento() {
        return tipoDePerfilamiento;
    }

    public Usuario getResponsablePerfilarManual() {
        return responsablePerfilarManual;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerfilAspirante(PerfilAspirante perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    public void setResponsablePerfilarManual(Usuario responsablePerfilarManual) {
        this.responsablePerfilarManual = responsablePerfilarManual;
    }
}
