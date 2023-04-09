package com.web.user.service.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.user.service.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
