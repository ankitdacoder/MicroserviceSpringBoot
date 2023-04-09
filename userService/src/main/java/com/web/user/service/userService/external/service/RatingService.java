package com.web.user.service.userService.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.user.service.userService.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/users/{userId}")
	List<Rating> getAllRatingByUserId(@PathVariable String userId);
}
