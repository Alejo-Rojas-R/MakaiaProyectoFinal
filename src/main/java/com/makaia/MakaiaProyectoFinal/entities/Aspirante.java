package com.makaia.MakaiaProyectoFinal.entities;

import com.makaia.MakaiaProyectoFinal.enums.*;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
@Table(name = "aspirante")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 50)
    @NotNull
    private String programa;

    @Column(length = 100)
    @NotNull
    private String nombre;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private TipoDocumento tipoDocumento;

    @Column(length = 20)
    @NotNull
    private Integer numDocumento;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Genero genero;

    @Column(length = 70)
    @NotNull
    private int edad ;

    @Column(length = 6)
    @NotNull
    private Date nacimiento;

    @Column(length = 15)
    @NotNull
    private Integer celular;

    @Column(length = 50)
    @NotNull
    private String nacionalidad;

    @Column(length = 50)
    @NotNull
    private String departamento;

    @Column(length = 50)
    @NotNull
    private String ciudad;

    @Column(length = 50)
    @NotNull
    private String residencia ;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Estrato estrato ;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Reconocimiento reconocimiento;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Discapacidad discapacidad ;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Poblacion poblacion;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private NivelEducativo nivelEducativo;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Ocupacion ocupacion ;

    @Column(length = 50)
    @NotNull
    private String tituloAcademico ;

    @Column(length = 50)
    @NotNull
    private String estudioTrabajo;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Salario salario;

    @Column(length = 100)
    @NotNull
    private String tiempoLibre;


    public Aspirante() {
    }

    public Aspirante(@NotNull String programa, @NotNull String nombre, @NotNull int edad, @NotNull String nacionalidad, @NotNull Estrato estrato,@NotNull Discapacidad discapacidad,
                     @NotNull NivelEducativo nivelEducativo, @NotNull Ocupacion ocupacion, @NotNull Salario salario) {
        this.programa = programa;
        this.nombre = nombre;
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

    public Estrato getEstrato() { return estrato;}

    public Discapacidad getDiscapacidad() {
        return discapacidad;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public Salario getSalario() {
        return salario;
    }


    @OneToOne(mappedBy = "aspirante")
    private Programador programador;

    @OneToOne(mappedBy = "aspirante")
    private Perfil perfil;

}
