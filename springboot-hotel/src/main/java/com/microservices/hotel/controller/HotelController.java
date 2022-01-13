package com.microservices.hotel.controller;

import com.microservices.hotel.model.Hotel;
import com.microservices.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/apirest/")
public class HotelController {

    private final IHotelService iHotelService;

    @Autowired
    public HotelController(IHotelService iHotelService) {
        this.iHotelService = iHotelService;
    }

    @GetMapping(value ="hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getHotels () {
        return iHotelService.getAvailablehotels();
    }
}
