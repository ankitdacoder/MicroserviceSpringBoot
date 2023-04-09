package com.web.user.service.userService.controller;

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

import com.web.user.service.userService.entities.User;
import com.web.user.service.userService.services.impl.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);

	}
 
	 @GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = userService.getAllUser();
		return ResponseEntity.ok(userList);

	}

}
