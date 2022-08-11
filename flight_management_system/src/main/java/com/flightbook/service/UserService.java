package com.flightbook.service;

import com.flightbook.entity.UserEntity;
import com.flightbook.model.User;

public interface UserService {
	public UserEntity saveUser(User user);
}
