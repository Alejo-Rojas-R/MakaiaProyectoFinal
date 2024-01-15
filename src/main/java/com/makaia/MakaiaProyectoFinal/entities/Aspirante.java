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

    @Enumerated(EnumType.ORDINAL)
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

    @Column(length = 2)
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
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Departamento departamento;

    @Column(length = 50)
    @NotNull
    private String ciudad;

    @Column(length = 80)
    @NotNull
    private String direccionResidencia;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Estrato estrato;

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
    private String ultimoTituloAcademico ;

    @Column(length = 50)
    @NotNull
    private String estudioTrabajo;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Salario salario;

    @Column(length = 100)
    @NotNull
    private String tiempoLibre;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private EstadoAspirante estadoAspirante = EstadoAspirante.PROCESO_DE_PRUEBA;


    public Aspirante() {
    }

    public Aspirante(@NotNull Long id, @NotNull Programa programa, @NotNull String nombre, @NotNull TipoDocumento tipoDocumento,
                     @NotNull Integer numDocumento, @NotNull Genero genero, @NotNull int edad, @NotNull Date nacimiento,
                     @NotNull Integer celular, @NotNull String email, @NotNull Departamento departamento,
                     @NotNull String ciudad, @NotNull String direccionResidencia, @NotNull Estrato estrato,
                     @NotNull Reconocimiento reconocimiento, @NotNull Discapacidad discapacidad, @NotNull Poblacion poblacion,
                     @NotNull NivelEducativo nivelEducativo, @NotNull Ocupacion ocupacion, @NotNull String ultimoTituloAcademico,
                     @NotNull String estudioTrabajo, @NotNull Salario salario, @NotNull String tiempoLibre) {
        this.id =id;
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

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
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

    public void setTituloAcademico(String ultimoTituloAcademico) {
        this.ultimoTituloAcademico = ultimoTituloAcademico;
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

    public Long getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public Departamento getDepartamento() {
        return departamento;
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

    public Programa getPrograma() {
        return programa;
    }

    public EstadoAspirante getEstadoAspirante() {
        return estadoAspirante ;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public void setEstadoAspirante(EstadoAspirante estadoAspirante) {
        this.estadoAspirante = estadoAspirante;
    }

    @OneToOne(mappedBy = "aspirante")
    private Programador programador;

    @OneToOne(mappedBy = "aspirante")
    private PerfilamientoAspirante perfilamientoAspirante;

}
