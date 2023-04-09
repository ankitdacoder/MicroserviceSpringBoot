package com.web.user.service.userService.Exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource Not Found On Server!! ");
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
