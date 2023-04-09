package com.demo.hotel.HotelService.services;

import java.util.List;

import com.demo.hotel.HotelService.entities.Hotel;

public interface HotelSercive {


	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotelById(String hotelId);
	
}
