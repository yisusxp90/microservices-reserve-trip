package com.microservices.hotel.repository;

import com.microservices.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRepositoy extends JpaRepository<Hotel, Integer> {
}
