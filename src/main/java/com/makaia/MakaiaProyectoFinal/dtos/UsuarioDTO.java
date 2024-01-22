package com.makaia.MakaiaProyectoFinal.dtos;

import lombok.Getter;

@Getter
public class UsuarioDTO {

    private String email;
    private String contraseña;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

}
