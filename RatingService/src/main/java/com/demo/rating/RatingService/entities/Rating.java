package com.demo.rating.RatingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ratings")
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedBack;
	
}
