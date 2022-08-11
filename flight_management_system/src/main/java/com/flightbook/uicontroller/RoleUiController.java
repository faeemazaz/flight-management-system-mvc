package com.flightbook.uicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightbook.entity.AuthGroupEntity;
import com.flightbook.service.RoleService;

@Controller
public class RoleUiController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/addrole", method = RequestMethod.GET)
	public String goToRole(Model mdl)
	{
		mdl.addAttribute("title", "Add Role");
		mdl.addAttribute("role", new AuthGroupEntity());
		return "addRole";
	}
	
	@RequestMapping(value="/role", method = RequestMethod.POST)
	public String insertRole(@ModelAttribute AuthGroupEntity authGroupEntity, @RequestParam Integer id, @RequestParam String authGroup)
	{
		authGroupEntity.setAuthGroup("ROLE_" + authGroup.toUpperCase());
		roleService.insertAuthGroup(authGroupEntity);
		return "redirect:/";
	}

}
