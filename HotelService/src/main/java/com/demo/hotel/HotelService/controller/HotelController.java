package com.demo.hotel.HotelService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hotel.HotelService.entities.Hotel;
import com.demo.hotel.HotelService.services.HotelSercive;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {

	private HotelSercive hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		Hotel savedHotel = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);

	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
		Hotel hotel = hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotel);

	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> hotelList = hotelService.getAllHotel();
		return ResponseEntity.ok(hotelList);

	}

}
