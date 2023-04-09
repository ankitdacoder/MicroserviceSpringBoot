package com.web.user.service.userService.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.user.service.userService.Exception.ResourceNotFoundException;
import com.web.user.service.userService.entities.Hotel;
import com.web.user.service.userService.entities.Rating;
import com.web.user.service.userService.entities.User;
import com.web.user.service.userService.external.service.HotelService;
import com.web.user.service.userService.external.service.RatingService;
import com.web.user.service.userService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found " + userId));

		/*
		Rating[] ratingOfUser = restTemplate
				                 .getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
		
		List<Rating> ratings= Arrays.stream(ratingOfUser).toList();
          
          */
		
		List<Rating> ratings=ratingService.getAllRatingByUserId( user.getUserId());

		if(!ratings.isEmpty())
		{
			List<Rating> ratingList = ratings.stream().map(rating -> {
				log.info("{}", rating.getHotelId());

				/*
				Hotel hotelObj = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
						Hotel.class);
				*/
				Hotel hotelObj=hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotelObj);
				return rating;

			}).collect(Collectors.toList());

			user.setRatings(ratingList);
		}
		

		return user;
	}

}
