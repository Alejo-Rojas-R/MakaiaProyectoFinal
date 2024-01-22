package com.makaia.MakaiaProyectoFinal.dtos;
import com.makaia.MakaiaProyectoFinal.entities.Aspirante;
import com.makaia.MakaiaProyectoFinal.enums.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.Date;

@Getter
public class AspiranteDTO {

    private String idAspirantePrueba;
    private Programa programa;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private Integer numDocumento;
    private Genero genero;
    private int edad;
    private Date nacimiento;
    private Integer celular;
    @Email(message = "El correo ingresado no es valido")
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


    public AspiranteDTO(Programa programa, String nombre, TipoDocumento tipoDocumento, Integer numDocumento,
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
    }

    public boolean validarSiAplicaParaBeca(AspiranteDTO dto){

        boolean edadBeca = dto.getEdad() >= 18 || dto.getEdad() <= 28;
        boolean ocupacionBeca = dto.getOcupacion().equals(Ocupacion.NO_ESTUDIO_NI_TRABAJO);
        boolean residenciaBeca = !dto.getDepartamento().equals(Departamento.RESIDE_FUERA_DE_COLOMBIA);
        boolean estratoBeca = dto.getEstrato().equals(Estrato.UNO)||dto.getEstrato().equals(Estrato.DOS)||dto.getEstrato().equals(Estrato.TRES);
        boolean nivelEducativoBeca =  dto.getNivelEducativo().equals(NivelEducativo.BACHILLERATO)
                ||dto.getNivelEducativo().equals(NivelEducativo.TECNICA)||dto.getNivelEducativo().equals(NivelEducativo.TECNOLOGIA);

        return edadBeca && ocupacionBeca && residenciaBeca && estratoBeca && nivelEducativoBeca;
    }

    public boolean validarSiAplicaParaComercial(AspiranteDTO dto){

        boolean edadComercial = dto.getEdad() >= 29;
        boolean estratoComercial = dto.getEstrato().equals(Estrato.TRES)||dto.getEstrato().equals(Estrato.CUATRO)
                ||dto.getEstrato().equals(Estrato.CINCO)||dto.getEstrato().equals(Estrato.SEIS);
        boolean salarioComercial = dto.getSalario().equals(Salario.DOS_O_MAS_SALARIOS_MINIMOS);
        boolean nivelEducativoComercial = dto.getNivelEducativo().equals(NivelEducativo.TECNICA)
                ||dto.getNivelEducativo().equals(NivelEducativo.TECNOLOGIA)||dto.getNivelEducativo().equals(NivelEducativo.PREGRADO);

        return edadComercial && estratoComercial && salarioComercial && nivelEducativoComercial;
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

