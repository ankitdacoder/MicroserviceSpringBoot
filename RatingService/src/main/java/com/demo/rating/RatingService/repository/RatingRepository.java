package com.demo.rating.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rating.RatingService.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	List<Rating> findByuserId(String userId);
	List<Rating> findByhotelId(String hotelId);
	
}
