package com.flightbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbook.entity.UserEntity;
import com.flightbook.model.User;
import com.flightbook.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public UserEntity insertUser(@RequestBody User user) {
		UserEntity userData = userService.saveUser(user);
		return userData;
	}
}
