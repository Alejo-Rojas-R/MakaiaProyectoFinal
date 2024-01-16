package com.makaia.MakaiaProyectoFinal.dtos;

import com.makaia.MakaiaProyectoFinal.enums.Rol;

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

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
