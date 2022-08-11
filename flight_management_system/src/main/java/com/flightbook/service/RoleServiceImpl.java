package com.flightbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbook.entity.AuthGroupEntity;
import com.flightbook.repository.AuthGroupRepo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private AuthGroupRepo authGroupRepo;
	
	@Override
	public AuthGroupEntity insertAuthGroup(AuthGroupEntity authGroupEntity) {
		return authGroupRepo.save(authGroupEntity);
	}
	
	@Override
	public List<AuthGroupEntity> getRole() {
		return authGroupRepo.findAll();
	}
	
}
