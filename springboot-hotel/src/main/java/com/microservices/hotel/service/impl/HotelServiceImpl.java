package com.microservices.hotel.service.impl;

import com.microservices.hotel.model.Hotel;
import com.microservices.hotel.repository.IHotelRepositoy;
import com.microservices.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService {

    private final IHotelRepositoy iHotelRepositoy;

    @Autowired
    public HotelServiceImpl(IHotelRepositoy iHotelRepositoy) {
        this.iHotelRepositoy = iHotelRepositoy;
    }

    @Override
    public List<Hotel> getAvailablehotels() {
        List<Hotel> hotels = iHotelRepositoy.findAll();
        return hotels.stream()
                .filter(t -> t.getAvailable() == 1)
                .collect(Collectors.toList());
    }
}
