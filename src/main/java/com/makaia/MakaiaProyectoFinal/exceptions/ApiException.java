package com.makaia.MakaiaProyectoFinal.exceptions;
import org.springframework.http.HttpStatusCode;
public class ApiException extends RuntimeException {
    private HttpStatusCode code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message, Throwable cause, HttpStatusCode code) {
        super(message, cause);
        this.code = code;
    }

    public ApiException(String message, HttpStatusCode code) {
        super(message);
        this.code = code;
    }

    public HttpStatusCode getCode() {
        return code;
    }


}
