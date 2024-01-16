package com.makaia.MakaiaProyectoFinal.dtos;
import com.makaia.MakaiaProyectoFinal.enums.*;

import java.util.Date;

public class AspiranteDTO {
    private Long id;
    private Programa programa;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private Integer numDocumento;
    private Genero genero;
    private int edad;
    private Date nacimiento;
    private Integer celular;
    private String email;
    private Departamento departamento;
    private String ciudad;
    private String direccionResidencia;
    private Estrato estrato;
    private Reconocimiento reconocimiento;
    private Discapacidad discapacidad;
    private Poblacion poblacion;
    private NivelEducativo nivelEducativo;
    private Ocupacion ocupacion;
    private String ultimoTituloAcademico;
    private String estudioTrabajo;
    private Salario salario;
    private String tiempoLibre;

    public AspiranteDTO() {
    }

    public AspiranteDTO(Long id ,Programa programa, String nombre, TipoDocumento tipoDocumento, Integer numDocumento,
                        Genero genero, int edad, Date nacimiento, Integer celular, String email, Departamento departamento,
                        String ciudad, String direccionResidencia, Estrato estrato, Reconocimiento reconocimiento,
                        Discapacidad discapacidad, Poblacion poblacion, NivelEducativo nivelEducativo, Ocupacion ocupacion,
                        String ultimoTituloAcademico, String estudioTrabajo, Salario salario, String tiempoLibre) {
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
        this.id=id;
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

    public String getEmail() {
        return email;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
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

    public String getUltimoTituloAcademico() {
        return ultimoTituloAcademico;
    }

    public String getEstudioTrabajo() {
        return estudioTrabajo;
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
    public String getTiempoLibre() {
        return tiempoLibre;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

}

