package com.makaia.MakaiaProyectoFinal.dtos;

public class UsuarioDTO {

    private String email;
    private String contrasena;
    private String rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String contrasena, String rol) {
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }
}
