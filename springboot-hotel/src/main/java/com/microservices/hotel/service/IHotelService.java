package com.microservices.hotel.service;

import com.microservices.hotel.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getAvailablehotels ();
}
