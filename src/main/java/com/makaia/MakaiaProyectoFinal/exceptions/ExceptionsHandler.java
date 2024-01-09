package com.makaia.MakaiaProyectoFinal.exceptions;

import com.makaia.MakaiaProyectoFinal.dtos.ResponseErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = { ApiException.class })
    public ResponseEntity<ResponseErrorDTO> handleShopApiException(ApiException e) {
        ResponseErrorDTO res = new ResponseErrorDTO(e.getMessage(), e.getCode().value());

        return new ResponseEntity<ResponseErrorDTO>(res, e.getCode());
    }
}
