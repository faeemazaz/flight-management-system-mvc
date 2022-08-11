package com.flightbook.service;

import java.util.List;

import com.flightbook.entity.AuthGroupEntity;

public interface RoleService {
	AuthGroupEntity insertAuthGroup(AuthGroupEntity authGroupEntity);
	public List<AuthGroupEntity> getRole();
}
