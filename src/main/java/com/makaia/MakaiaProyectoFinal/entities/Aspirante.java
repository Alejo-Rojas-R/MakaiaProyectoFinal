package com.makaia.MakaiaProyectoFinal.entities;

import com.makaia.MakaiaProyectoFinal.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
@Getter
@Table(name = "aspirante")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 100)
    @NotNull
    private String idAspirantePrueba;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Programa programa;

    @Column(length = 100)
    @NotNull
    private String nombre;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoDocumento tipoDocumento;

    @Column(length = 20)
    @NotNull
    private Integer numDocumento;

    @Enumerated(EnumType.STRING)
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

    @Column()
    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Departamento departamento;

    @Column(length = 50)
    @NotNull
    private String ciudad;

    @Column(length = 80)
    @NotNull
    private String direccionResidencia;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Estrato estrato;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Reconocimiento reconocimiento;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Discapacidad discapacidad ;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Poblacion poblacion;

    @Enumerated(EnumType.STRING)
    @NotNull
    private NivelEducativo nivelEducativo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Ocupacion ocupacion ;

    @Column(length = 50)
    @NotNull
    private String ultimoTituloAcademico ;

    @Column(length = 50)
    @NotNull
    private String estudioTrabajo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Salario salario;

    @Column(length = 100)
    @NotNull
    private String tiempoLibre;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoAspirante estadoAspirante = EstadoAspirante.PROCESO_DE_PRUEBA;


    public Aspirante() {
    }

    public Aspirante(@NotNull Programa programa, @NotNull String nombre, @NotNull TipoDocumento tipoDocumento,
                     @NotNull Integer numDocumento, @NotNull Genero genero, @NotNull int edad, @NotNull Date nacimiento,
                     @NotNull Integer celular, @NotNull String email, @NotNull Departamento departamento,
                     @NotNull String ciudad, @NotNull String direccionResidencia, @NotNull Estrato estrato,
                     @NotNull Reconocimiento reconocimiento, @NotNull Discapacidad discapacidad, @NotNull Poblacion poblacion,
                     @NotNull NivelEducativo nivelEducativo, @NotNull Ocupacion ocupacion, @NotNull String ultimoTituloAcademico,
                     @NotNull String estudioTrabajo, @NotNull Salario salario, @NotNull String tiempoLibre) {
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

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
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
