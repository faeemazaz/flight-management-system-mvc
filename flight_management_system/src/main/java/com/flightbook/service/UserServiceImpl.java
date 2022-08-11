package com.flightbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightbook.entity.AuthGroupEntity;
import com.flightbook.entity.UserEntity;
import com.flightbook.model.User;
import com.flightbook.repository.AuthGroupRepo;
import com.flightbook.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AuthGroupRepo authGroupRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserEntity saveUser(User user) {
		Optional<AuthGroupEntity> getAuthRefe = authGroupRepo.findById(user.getAuthId());
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setAuthGroupEntity(getAuthRefe.get());
		userRepo.save(userEntity);

		return userEntity;
	}
}
