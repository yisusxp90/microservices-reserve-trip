package com.microservices.flights.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="flights")
public class Flight implements Serializable {
    private static final long serialVersionUID = 7621349082400803962L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    private String company;
    private String date;
    private int availableSeats;
    private double price;

    public Flight() {
        super();
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
