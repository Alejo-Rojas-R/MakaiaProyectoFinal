package com.makaia.MakaiaProyectoFinal.dtos;
import java.util.Date;

public class AspiranteDTO {
    private String programa;
    private String nombre;
    private String tipoDocumento;
    private Integer numDocumento;
    private String genero;
    private int edad;
    private Date nacimiento;
    private Integer celular;
    private String email;
    private String departamento;
    private String ciudad;
    private String direccionResidencia;
    private String estrato;
    private String reconocimiento;
    private String discapacidad;
    private String poblacion;
    private String nivelEducativo;
    private String ocupacion;
    private String ultimoTituloAcademico;
    private String estudioTrabajo;
    private String salario;
    private String tiempoLibre;

    public AspiranteDTO() {
    }

    public AspiranteDTO(String programa, String nombre, String tipoDocumento, Integer numDocumento, String genero,
                        int edad, Date nacimiento, Integer celular, String email, String departamento, String ciudad,
                        String direccionResidencia, String estrato, String reconocimiento, String discapacidad,
                        String poblacion, String nivelEducativo, String ocupacion, String ultimoTituloAcademico,
                        String estudioTrabajo, String salario, String tiempoLibre) {
        this.programa = programa;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.genero = genero;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.celular = celular;
        this.email = email;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccionResidencia = direccionResidencia;
        this.estrato = estrato;
        this.reconocimiento = reconocimiento;
        this.discapacidad = discapacidad;
        this.poblacion = poblacion;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.ultimoTituloAcademico = ultimoTituloAcademico;
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

    public Integer getNumDocumento() {
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

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public String getEstrato() {
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

    public String getUltimoTituloAcademico() {
        return ultimoTituloAcademico;
    }

    public String getEstudioTrabajo() {
        return estudioTrabajo;
    }

    public String getSalario() {
        return salario;
    }

    public String getTiempoLibre() {
        return tiempoLibre;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

}

