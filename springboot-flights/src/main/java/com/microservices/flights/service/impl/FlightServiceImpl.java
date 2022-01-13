package com.microservices.flights.service.impl;

import com.microservices.flights.exceptions.FlightsBusinessException;
import com.microservices.flights.model.Flight;
import com.microservices.flights.repository.IFlightRepository;
import com.microservices.flights.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements IFlightService {

    private final IFlightRepository iFlightRepository;

    @Autowired
    public FlightServiceImpl(IFlightRepository iFlightRepository) {
        this.iFlightRepository = iFlightRepository;
    }

    @Override
    public List<Flight> getAvailableFlights(int seats) {
        return iFlightRepository.findAll()
                .stream()
                .filter(t -> t.getAvailableSeats() >= seats)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean updateAvailableSeats(int flightId, int seats) {
        Optional<Flight> flightOptional = iFlightRepository.findById(flightId);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            if (seats > flight.getAvailableSeats()) {
                throw new FlightsBusinessException("insufficient seats in this flight", 111);
            }
            flight.setAvailableSeats(flight.getAvailableSeats() - seats);
            iFlightRepository.save(flightOptional.get());
            return true;
        }
        throw new FlightsBusinessException("flight doesn't exist", 111);
    }

    @Override
    @Transactional
    public void saveFlight(Flight flight) throws Exception {
        iFlightRepository.save(flight);
    }
}
