package com.makaia.MakaiaProyectoFinal.entities;

import com.makaia.MakaiaProyectoFinal.enums.*;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "aspirante")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Enumerated(EnumType.STRING)
    private Programa programa;

    @Column(length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(length = 20)
    private Integer numDocumento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(length = 70)
    private int edad ;

    @Column(length = 6)
    private Date nacimiento;

    @Column(length = 15)
    private Integer celular;

    @Column(length = 50)
    private String nacionalidad;

    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    @Column(length = 50)
    private String ciudad;

    @Column(length = 50)
    private String residencia ;

    @Enumerated(EnumType.STRING)
    private Estrato estrato;

    @Enumerated(EnumType.STRING)
    private Reconocimiento reconocimiento;

    @Enumerated(EnumType.STRING)
    private Discapacidad discapacidad ;

    @Enumerated(EnumType.STRING)
    private Poblacion poblacion;

    @Enumerated(EnumType.STRING)
    private NivelEducativo nivelEducativo;

    @Enumerated(EnumType.STRING)
    private Ocupacion ocupacion ;

    @Column(length = 50)
    private String estudioTrabajo;

    @Enumerated(EnumType.STRING)
    private Salario salario;

    @Column(length = 100)
    private String tiempoLibre;

    @OneToOne(mappedBy = "aspirante")
    private Programador programador;

    @OneToOne(mappedBy = "aspirante")
    private PerfilamientoAspirante perfilamientoAspirante;

    public Aspirante() {
    }

    public Aspirante(Programa programa, String nombre, TipoDocumento tipoDocumento, Integer numDocumento, Genero genero, int edad, Date nacimiento, Integer celular, String nacionalidad, Departamento departamento, String ciudad, String residencia, Estrato estrato, Reconocimiento reconocimiento, Discapacidad discapacidad, Poblacion poblacion, NivelEducativo nivelEducativo, Ocupacion ocupacion, String estudioTrabajo, Salario salario, String tiempoLibre, Programador programador, PerfilamientoAspirante perfilamientoAspirante) {
        this.programa = programa;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.genero = genero;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.celular = celular;
        this.nacionalidad = nacionalidad;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.residencia = residencia;
        this.estrato = estrato;
        this.reconocimiento = reconocimiento;
        this.discapacidad = discapacidad;
        this.poblacion = poblacion;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.estudioTrabajo = estudioTrabajo;
        this.salario = salario;
        this.tiempoLibre = tiempoLibre;
        this.programador = programador;
        this.perfilamientoAspirante = perfilamientoAspirante;
    }

    public Programa getPrograma() {
        return programa;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public Integer getNumDocumento() {
        return numDocumento;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public Integer getCelular() {
        return celular;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getResidencia() {
        return residencia;
    }

    public Estrato getEstrato() {
        return estrato;
    }

    public Reconocimiento getReconocimiento() {
        return reconocimiento;
    }

    public Discapacidad getDiscapacidad() {
        return discapacidad;
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public String getEstudioTrabajo() {
        return estudioTrabajo;
    }

    public Salario getSalario() {
        return salario;
    }

    public String getTiempoLibre() {
        return tiempoLibre;
    }

    public Programador getProgramador() {
        return programador;
    }

    public PerfilamientoAspirante getPerfil() {
        return perfilamientoAspirante;
    }
}
