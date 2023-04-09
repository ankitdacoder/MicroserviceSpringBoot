package com.demo.rating.RatingService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rating.RatingService.entities.Rating;
import com.demo.rating.RatingService.repository.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating create(Rating rating) {
		return ratingRepository.save(rating);
	}

	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	public List<Rating> getAllRatingsUserId(String userId) {
		return ratingRepository.findByuserId(userId);
	}

	public List<Rating> getAllRatingsHotelId(String hotelId) {
		return ratingRepository.findByhotelId(hotelId);
	}

}
