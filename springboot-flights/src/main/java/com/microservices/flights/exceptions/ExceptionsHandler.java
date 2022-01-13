package com.microservices.flights.exceptions;

import com.microservices.flights.model.FlightResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FlightResponse> handleGenericException(Exception e){
        FlightResponse flightResponse = new FlightResponse(99, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(flightResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlightsBusinessException.class)
    public ResponseEntity<FlightResponse> handleFlightBusinessException(FlightsBusinessException e){
        FlightResponse flightResponse = new FlightResponse(e.getCode(), e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(flightResponse, HttpStatus.BAD_REQUEST);
    }
}
