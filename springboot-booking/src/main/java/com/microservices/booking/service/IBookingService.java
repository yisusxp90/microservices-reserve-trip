package com.microservices.booking.service;

import com.microservices.booking.model.Booking;

import java.util.List;

public interface IBookingService {
    void generateBooking(Booking booking, int peopleAmount) throws Exception;
    List<Booking> getBookings();
}
