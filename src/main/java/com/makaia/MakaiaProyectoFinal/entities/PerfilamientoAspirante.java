package com.makaia.MakaiaProyectoFinal.entities;


import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import com.makaia.MakaiaProyectoFinal.enums.TipoDePerfilamiento;
import jakarta.persistence.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
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

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private TipoDePerfilamiento tipoDePerfilamiento;

    @ManyToOne
    private Usuario responsablePerfilarManual;

    public PerfilamientoAspirante() {
    }

    public PerfilamientoAspirante(Aspirante aspirante, @NotNull PerfilAspirante perfilAspirante,
                                  @NotNull TipoDePerfilamiento tipoDePerfilamiento) {
        this.aspirante = aspirante;
        this.perfilAspirante = perfilAspirante;
        this.tipoDePerfilamiento = tipoDePerfilamiento;
    }



    public void setPerfilAspirante(PerfilAspirante perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    public void setResponsablePerfilarManual(Usuario responsablePerfilarManual) {
        this.responsablePerfilarManual = responsablePerfilarManual;
    }

    public void setTipoDePerfilamiento(TipoDePerfilamiento tipoDePerfilamiento) {
        this.tipoDePerfilamiento = tipoDePerfilamiento;
    }
}
