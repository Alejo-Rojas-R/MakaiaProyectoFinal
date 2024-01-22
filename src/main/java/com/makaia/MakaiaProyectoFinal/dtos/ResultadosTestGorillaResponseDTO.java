package com.makaia.MakaiaProyectoFinal.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResultadosTestGorillaResponseDTO {


    @JsonProperty("count")
    private String contador;

    @JsonProperty("results")
    private List<ResultadoDeAspiranteTestGorillaDTO> resultadosDeAspirantes;
}
