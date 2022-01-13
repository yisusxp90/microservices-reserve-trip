package com.microservices.flights.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FlightsBusinessException extends RuntimeException {

    private final Integer code;

    public FlightsBusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public FlightsBusinessException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
