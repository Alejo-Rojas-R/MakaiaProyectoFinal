package com.makaia.MakaiaProyectoFinal.dtos;
import com.makaia.MakaiaProyectoFinal.enums.*;

import java.util.Date;

public class AspiranteDTO {
    private Long id;
    private Programa programa;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private int numDocumento;
    private Genero genero;
    private int edad;
    private Date nacimiento;
    private Integer celular;
    private String nacionalidad;
    private String departamento;
    private String ciudad;
    private String residencia;
    private Estrato estrato;
    private Reconocimiento reconocimiento;
    private Discapacidad discapacidad;
    private Poblacion poblacion;
    private NivelEducativo nivelEducativo;
    private Ocupacion ocupacion;
    private String tituloAcademico;
    private String estudioTrabajo;
    private Salario salario;
    private String tiempoLibre;

    public AspiranteDTO() {
    }

    public AspiranteDTO(String nombre,int edad, String nacionalidad, Estrato estrato, Discapacidad discapacidad, NivelEducativo nivelEducativo, Ocupacion ocupacion, Salario salario, Long id, Programa programa
    ) {
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.estrato = estrato;
        this.discapacidad = discapacidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.salario = salario;
        this.id=id;
        this.programa=programa;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Estrato getEstrato() {
        return estrato;
    }

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

    public Long getId() {
        return id;
    }

    public Programa getPrograma() {
        return programa;
    }
}

