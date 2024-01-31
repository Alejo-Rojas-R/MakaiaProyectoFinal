package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.PerfilAspirante;
import com.makaia.MakaiaProyectoFinal.enums.TipoDePerfilamiento;
import lombok.Getter;

@Getter
public class PerfilamientoAspirannteDTO {

    private Long idApirante;
    private PerfilAspirante perfilAspirante;
    private TipoDePerfilamiento tipoDePerfilamiento;
    private Long responsablePerfilarManual;

    public PerfilamientoAspirannteDTO() {
    }

    public PerfilamientoAspirannteDTO(Long idApirante, PerfilAspirante perfilAspirante, TipoDePerfilamiento tipoDePerfilamiento, Long responsablePerfilarManual) {
        this.idApirante = idApirante;
        this.perfilAspirante = perfilAspirante;
        this.tipoDePerfilamiento = tipoDePerfilamiento;
        this.responsablePerfilarManual = responsablePerfilarManual;
    }

    public void setPerfilAspirante(PerfilAspirante perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    public void setResponsablePerfilarManual(Long responsablePerfilarManual) {
        this.responsablePerfilarManual = responsablePerfilarManual;
    }

    public void setTipoDePerfilamiento(TipoDePerfilamiento tipoDePerfilamiento) {
        this.tipoDePerfilamiento = tipoDePerfilamiento;
    }
}
