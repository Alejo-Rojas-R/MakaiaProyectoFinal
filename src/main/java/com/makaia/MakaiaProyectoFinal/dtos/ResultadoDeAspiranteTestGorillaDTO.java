package com.makaia.MakaiaProyectoFinal.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultadoDeAspiranteTestGorillaDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String nombreDePrueba;

    @JsonProperty("score")
    private Integer puntaje;

    @JsonProperty("status")
    private String estadoDePrueba;

    @JsonProperty("completed")
    private String completada;

    @JsonProperty("test_id")
    private Integer idDePrueba;

    @JsonProperty("custom_questions")
    private String preguntas;

    @JsonProperty("algorithm")
    private String algoritmoDePrueba;

    @JsonProperty("is_code_test")
    private String personalidad;

    @JsonProperty("score_display")
    private String puntajeDePersonalidad;

}
