package com.makaia.MakaiaProyectoFinal.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 50)
    private String email ;

    @Column(length = 50)
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    @OneToMany(mappedBy = "responsablePerfilarManual")
    List<PerfilamientoAspirante> usuarioResponsable;

}
