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

    public AspiranteDTO(String programa, String nombre, String tipoDocumento, int numDocumento, String genero, int edad, Date nacimiento, Integer celular, String nacionalidad, String departamento, String ciudad, String residencia, int estrato, String reconocimiento, String discapacidad, String poblacion, String nivelEducativo, String ocupacion, String tituloAcademico, String estudioTrabajo, double salario, String tiempoLibre) {
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
        this.tituloAcademico = tituloAcademico;
        this.estudioTrabajo = estudioTrabajo;
        this.salario = salario;
        this.tiempoLibre = tiempoLibre;
    }

    public String getPrograma() {
        return programa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public String getGenero() {
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

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getResidencia() {
        return residencia;
    }

    public int getEstrato() {
        return estrato;
    }

    public String getReconocimiento() {
        return reconocimiento;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public String getEstudioTrabajo() {
        return estudioTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public String getTiempoLibre() {
        return tiempoLibre;
    }
}

