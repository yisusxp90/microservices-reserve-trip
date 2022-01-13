package com.microservices.flights.controller;

import com.microservices.flights.circuitBreaker.CircuitBreakerService;
import com.microservices.flights.model.Flight;
import com.microservices.flights.service.IFlightService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/apirest/")
@Api(value="FlightResource", description="Controlador que maneja peticiones de vuelos")
public class FlightController {

    private final IFlightService iFlightService;
    private final CircuitBreakerService circuitBreakerService;

    @Autowired
    public FlightController(IFlightService iFlightService, CircuitBreakerService circuitBreakerService) {
        this.iFlightService = iFlightService;
        this.circuitBreakerService = circuitBreakerService;
    }

    @GetMapping(value ="flights/{seats}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> getFlights(@PathVariable("seats") int seats) {
        return iFlightService.getAvailableFlights(seats);

    }

    @PutMapping(value= "flights/{fightId}/{seats}")
    public void updateFlight(@PathVariable("fightId") int fightId,
                                @PathVariable("seats") int seats) {
        circuitBreakerService.executeRetrieveContentPurchase(() -> this.iFlightService.updateAvailableSeats(fightId, seats));
    }
}
