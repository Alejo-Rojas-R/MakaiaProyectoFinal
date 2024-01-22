package com.makaia.MakaiaProyectoFinal.dtos;

import lombok.Getter;

@Getter
public class PerfilamientoAspirannteDTO {

    private Long idApirante;
    private String perfilAspirante;
    private String tipoDePerfilamiento;
    private Long responsablePerfilarManual;

    public PerfilamientoAspirannteDTO() {
    }

    public PerfilamientoAspirannteDTO(Long idApirante, String perfilAspirante, String tipoDePerfilamiento) {
        this.idApirante = idApirante;
        this.perfilAspirante = perfilAspirante;
        this.tipoDePerfilamiento = tipoDePerfilamiento;
    }

    public void setPerfilAspirante(String perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    public void setResponsablePerfilarManual(Long responsablePerfilarManual) {
        this.responsablePerfilarManual = responsablePerfilarManual;
    }

    public void setTipoDePerfilamiento(String tipoDePerfilamiento) {
        this.tipoDePerfilamiento = tipoDePerfilamiento;
    }
}
