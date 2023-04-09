package com.web.user.service.userService.services.impl;

import java.util.List;

import com.web.user.service.userService.entities.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);
}
