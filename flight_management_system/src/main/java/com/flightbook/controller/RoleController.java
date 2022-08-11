package com.flightbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbook.entity.AuthGroupEntity;
import com.flightbook.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public AuthGroupEntity addRoles(@RequestBody AuthGroupEntity authGroupEntity) {
		return roleService.insertAuthGroup(authGroupEntity);
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public List<AuthGroupEntity> getRoles() {
		return roleService.getRole();
	}
}
