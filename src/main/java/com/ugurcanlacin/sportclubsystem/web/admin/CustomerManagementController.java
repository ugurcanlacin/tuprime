package com.ugurcanlacin.sportclubsystem.web.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@Controller
@RequestMapping("/admin/customermanagement")
public class CustomerManagementController {
	
	@Resource(name = "userService")
	private UserService userService;
		
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public ModelAndView selectUser(@PathVariable("id") int id) {
		User userForm = userService.find(id);
		ModelAndView model = new ModelAndView("trainer/select");
		model.addObject("userForm", userForm);
		return model;
	}

}
