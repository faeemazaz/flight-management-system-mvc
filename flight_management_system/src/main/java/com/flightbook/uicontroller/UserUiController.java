package com.flightbook.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightbook.entity.AuthGroupEntity;
import com.flightbook.model.User;
import com.flightbook.service.RoleService;
import com.flightbook.service.UserService;

@Controller
public class UserUiController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model mdl) {
		mdl.addAttribute("title", "Signin");
		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String goToRegistration(Model mdl) {
		mdl.addAttribute("title", "Signup");
		List<AuthGroupEntity> getRoles = roleService.getRole();
		mdl.addAttribute("roles", getRoles);
		return "registration";
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}
}
