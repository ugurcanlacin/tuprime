package com.tuprime.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.user.UserService;
import com.tuprime.common.security.AuthenticationService;
import com.tuprime.entities.Admin;
import com.tuprime.entities.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Resource(name = "authenticationService")
	private AuthenticationService authService;
	
	@Resource(name = "userService")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AuthenticationService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard() {
		logger.info(authService.getAuthenticatedAdmin()+" executed getDashboard()");
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping("/usermanagement")
	public ModelAndView getUserManagement() {
		ModelAndView model = new ModelAndView("admin/userManagement");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		logger.info(authService.getAuthenticatedAdmin()+" executed getUserManagement()");
		return model;
	}

	@RequestMapping("/customermanagement")
	public ModelAndView getCustomerManagement() {
		ModelAndView model = new ModelAndView("trainer/customerManagement");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		logger.info(authService.getAuthenticatedAdmin()+" executed getCustomerManagement()");
		return model;
	}
}
