package com.makaia.MakaiaProyectoFinal.dtos;
import com.makaia.MakaiaProyectoFinal.enums.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import java.util.Date;
@Getter
public class ModificarAspiranteDTO {
    private Programa programa;
    private Long celular;
    private String direccionResidencia;

    public ModificarAspiranteDTO() {
    }

    public ModificarAspiranteDTO(Programa programa, Long celular, String direccionResidencia) {
        this.programa = programa;
        this.celular = celular;
        this.direccionResidencia = direccionResidencia;
    }
}

