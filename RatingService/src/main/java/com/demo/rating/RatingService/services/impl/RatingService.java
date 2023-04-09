package com.demo.rating.RatingService.services.impl;

import java.util.List;

import com.demo.rating.RatingService.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);

	List<Rating> getAllRatings();

	List<Rating> getAllRatingsUserId(String userId);

	List<Rating>getAllRatingsHotelId(String hotelId);

}
