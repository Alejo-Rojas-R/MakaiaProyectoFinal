package com.makaia.MakaiaProyectoFinal.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorDTO {
    private String message;

    private Integer code;

    public ResponseErrorDTO(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}
