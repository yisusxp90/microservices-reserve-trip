package com.microservices.booking.service.impl;

import com.microservices.booking.model.Booking;
import com.microservices.booking.model.Hotel;
import com.microservices.booking.repository.IBookingRepository;
import com.microservices.booking.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {

    private final IBookingRepository iBookingRepository;
    private final RestTemplate template;
    private final static String URL_FLIGHTS = "http://microservicios-flights";
    private final static String URL_HOTELS = "http://microservicios-hotels";

    @Autowired
    public BookingServiceImpl(IBookingRepository iBookingRepository, RestTemplate template) {
        this.iBookingRepository = iBookingRepository;
        this.template = template;
    }

    @Override
    @Transactional
    public void generateBooking(Booking booking, int peopleAmount) throws Exception {
        Hotel[] hotels = template.getForObject(URL_HOTELS + "/apirest/hotels", Hotel[].class);
        assert hotels != null;
        boolean exist = Arrays.stream(hotels).anyMatch(h -> h.getHotelId().equals(booking.getHotel()));
        if(!exist){
            throw new Exception("Hotel not found");
        }
        /*Como no le pasamos nada en el cuerpo ponemos null*/
        template.put(URL_FLIGHTS + "/apirest/flights/{fightId}/{seats}",null, booking.getFlight(), peopleAmount);
        iBookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookings() {
        return iBookingRepository.findAll();
    }
}
