package com.microservices.booking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="bookings")
public class Booking implements Serializable {
    private static final long serialVersionUID = 8199142941605876731L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String dni;
    private int hotel;
    private String name;
    private int flight;

    public Booking() {
        super();
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }
}
