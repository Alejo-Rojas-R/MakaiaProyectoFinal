package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.EstadoAspirante;

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

    public Long getIdApirante() {
        return idApirante;
    }

    public String getPerfilAspirante() {
        return perfilAspirante;
    }

    public String getTipoDePerfilamiento() {
        return tipoDePerfilamiento;
    }

    public Long getResponsablePerfilarManual() {
        return responsablePerfilarManual;
    }

    public void setPerfilAspirante(String perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    public void setResponsablePerfilarManual(Long responsablePerfilarManual) {
        this.responsablePerfilarManual = responsablePerfilarManual;
    }
}
