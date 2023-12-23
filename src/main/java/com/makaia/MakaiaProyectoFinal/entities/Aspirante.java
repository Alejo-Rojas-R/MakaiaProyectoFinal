package com.makaia.MakaiaProyectoFinal.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "aspirante")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 50)
    private String programa;

    @Column(length = 100)
    private String nombre;

    @Column(length = 50)
    private String tipoDocumento;

    @Column(length = 20)
    private Integer numDocumento;

    @Column(length = 20)
    private String genero;

    @Column(length = 70)
    private int edad ;

    @Column(length = 6)
    private Date nacimiento;

    @Column(length = 15)
    private Integer celular;

    @Column(length = 50)
    private String nacionalidad;

    @Column(length = 50)
    private String departamento;

    @Column(length = 50)
    private String ciudad;

    @Column(length = 50)
    private String residencia ;

    @Column(length = 1)
    private int estrato ;

    @Column(length = 50)
    private String reconocimiento;

    @Column(length = 50)
    private String discapacidad ;

    @Column(length = 50)
    private String poblacion;

    @Column(length = 50)
    private String nivelEducativo;

    @Column(length = 50)
    private String ocupacion ;

    @Column(length = 50)
    private String tituloAcademico ;

    @Column(length = 50)
    private String estudioTrabajo;

    @Column(length = 20)
    private double salario;

    @Column(length = 100)
    private String tiempoLibre;


    public Aspirante() {
    }

    public Aspirante(int edad, String nacionalidad, int estrato, String discapacidad,
                     String nivelEducativo, String ocupacion, double salario) {
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.estrato = estrato;
        this.discapacidad = discapacidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEstrato() {
        return estrato;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public double getSalario() {
        return salario;
    }


    @OneToOne(mappedBy = "aspirante")
    private Programador programador;

    @OneToOne(mappedBy = "aspirante")
    private Perfil perfil;

}
