package com.demo.rating.RatingService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.rating.RatingService.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundExcetion(ResourceNotFoundException ex) {

		ex.getMessage();
		ApiResponse apiResponse = ApiResponse.builder().message(ex.getMessage()).success(true)
				.status(HttpStatus.NOT_FOUND).build();

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
