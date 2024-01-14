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
    private Programa programa;


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

    public Aspirante(@NotNull Programa programa, @NotNull String nombre, @NotNull int edad, @NotNull String nacionalidad, @NotNull Estrato estrato,@NotNull Discapacidad discapacidad,
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumDocumento(Integer numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public void setEstrato(Estrato estrato) {
        this.estrato = estrato;
    }

    public void setReconocimiento(Reconocimiento reconocimiento) {
        this.reconocimiento = reconocimiento;
    }

    public void setDiscapacidad(Discapacidad discapacidad) {
        this.discapacidad = discapacidad;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public void setEstudioTrabajo(String estudioTrabajo) {
        this.estudioTrabajo = estudioTrabajo;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public void setTiempoLibre(String tiempoLibre) {
        this.tiempoLibre = tiempoLibre;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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

    public Programa getPrograma() {
        return programa;
    }
    public void setPrograma(@NotNull Programa programa){
        if (programa == null) {
            throw new IllegalArgumentException("El programa no puede ser nulo");
        }
        this.programa = programa;
    }


    @OneToOne(mappedBy = "aspirante")
    private Programador programador;

    @OneToOne(mappedBy = "aspirante")
    private Perfil perfil;

}
