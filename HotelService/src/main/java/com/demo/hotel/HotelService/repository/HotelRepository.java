package com.demo.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
