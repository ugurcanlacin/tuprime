package com.ugurcanlacin.sportclubsystem.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource(name="userService")
	UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard(){
		return	new ModelAndView("admin/index");
	}
	
	@RequestMapping("/usermanagement")
	public ModelAndView getUserManagement(){
		ModelAndView  model = new ModelAndView("admin/userManagement");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		return model;
	}
}
