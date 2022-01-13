package com.microservices.booking.controller;

import com.microservices.booking.model.Booking;
import com.microservices.booking.service.IBookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/apirest/")
@Api(value="BookingResource", description="Controlador que maneja peticiones de reservas")
public class BookingController {

    private final IBookingService iBookingService;

    @Autowired
    public BookingController(IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }

    @ApiOperation(value = "genera reserva y actualiza la base de datos con la disponibilidad de úestos")
    @PostMapping(value="booking/{people}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generateBooking(@ApiParam(value = "informacion de la reserva") @RequestBody Booking booking,
                                @ApiParam(value = "cantidad a ocupar para la reserva") @PathVariable("people") int people) throws Exception {
        this.iBookingService.generateBooking(booking, people);
        return new ResponseEntity<>("Reserva generada exitosamente", HttpStatus.OK);
    }

    @ApiOperation(value = "Devuelve el listado de reservas realizadas")
    @GetMapping(value="bookings", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Booking>> getReservas() {
        List<Booking> bookings = this.iBookingService.getBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
