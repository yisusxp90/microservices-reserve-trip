package com.microservices.flights.service;

import com.microservices.flights.exceptions.FlightsBusinessException;
import com.microservices.flights.model.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> getAvailableFlights(int seats);
    boolean updateAvailableSeats(int flightId, int seats);
    void saveFlight(Flight fligh) throws Exception;
}
