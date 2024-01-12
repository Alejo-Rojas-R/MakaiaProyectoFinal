package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.Estado;

public class PerfilamientoAspiranteDTO {
private long idApirante;

private String aspirante;

private String estado;

    public PerfilamientoAspiranteDTO() {
    }

    public PerfilamientoAspiranteDTO(long idApirante, String aspirante, String estado) {
        this.idApirante = idApirante;
        this.aspirante = aspirante;
        this.estado = estado;
    }

    public long getIdApirante() {
        return idApirante;
    }

    public String getAspirante() {
        return aspirante;
    }

    public String getEstado() {
        return estado;
    }
}
