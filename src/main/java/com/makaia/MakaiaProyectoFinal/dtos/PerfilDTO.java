package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.Estado;

public class PerfilDTO {
private long idApirante;
private Estado estado;

    public PerfilDTO() {
    }

    public PerfilDTO(long idApirante, Estado estado) {
        this.idApirante = idApirante;
        this.estado = estado;
    }

    public long getIdApirante() {
        return idApirante;
    }

    public Estado getEstado() {
        return estado;
    }
}
