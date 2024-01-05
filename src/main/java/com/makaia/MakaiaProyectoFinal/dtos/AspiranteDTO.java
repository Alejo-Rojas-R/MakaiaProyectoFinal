package com.makaia.MakaiaProyectoFinal.dtos;
import java.util.Date;

public class AspiranteDTO {
    private String programa;
    private String nombre;
    private String tipoDocumento;
    private int numDocumento;
    private String genero;
    private int edad;
    private Date nacimiento;
    private Integer celular;
    private String nacionalidad;
    private String departamento;
    private String ciudad;
    private String residencia;
    private int estrato;
    private String reconocimiento;
    private String discapacidad;
    private String poblacion;
    private String nivelEducativo;
    private String ocupacion;
    private String tituloAcademico;
    private String estudioTrabajo;
    private double salario;
    private String tiempoLibre;

    public AspiranteDTO() {
    }

    public AspiranteDTO(int edad, String nacionalidad, int estrato, String discapacidad, String nivelEducativo, String ocupacion, double salario) {
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.estrato = estrato;
        this.discapacidad = discapacidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.salario = salario;
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
}

