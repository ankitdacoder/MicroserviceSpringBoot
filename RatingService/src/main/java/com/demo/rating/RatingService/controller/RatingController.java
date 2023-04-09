package com.demo.rating.RatingService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rating.RatingService.entities.Rating;
import com.demo.rating.RatingService.services.impl.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		Rating savedRating = ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getRatings() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingService.getAllRatingsUserId(userId));
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingService.getAllRatingsHotelId(hotelId));
	}

}
