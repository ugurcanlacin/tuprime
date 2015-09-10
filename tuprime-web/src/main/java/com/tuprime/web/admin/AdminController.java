package com.tuprime.web.admin;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.user.UserService;
import com.tuprime.entities.User;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource(name = "userService")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard() {
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping("/usermanagement")
	public ModelAndView getUserManagement() {
		ModelAndView model = new ModelAndView("admin/userManagement");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		return model;
	}

	@RequestMapping("/customermanagement")
	public ModelAndView getCustomerManagement() {
		ModelAndView model = new ModelAndView("trainer/customerManagement");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		return model;
	}
}
