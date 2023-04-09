package com.demo.hotel.HotelService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hotel.HotelService.entities.Hotel;
import com.demo.hotel.HotelService.exception.ResourceNotFoundException;
import com.demo.hotel.HotelService.repository.HotelRepository;
import com.demo.hotel.HotelService.services.HotelSercive;

@Service
public class HotelServiceImpl implements HotelSercive {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found : "+hotelId));
	}

}
