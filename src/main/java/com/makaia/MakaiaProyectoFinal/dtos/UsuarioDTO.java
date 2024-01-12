package com.makaia.MakaiaProyectoFinal.dtos;

public class UsuarioDTO {

    private String email;
    private String contraseña;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }
}
