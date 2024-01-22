package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.Rol;
import lombok.Getter;

@Getter
public class UsuarioDTO {

    private String email;
    private String contrasena;
    private Rol rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String contrasena, Rol rol) {
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }

}
