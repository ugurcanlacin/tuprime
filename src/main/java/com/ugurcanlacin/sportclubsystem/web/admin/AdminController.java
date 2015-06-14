package com.ugurcanlacin.sportclubsystem.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard(){
		return	new ModelAndView("admin/index");
	}
	
	@RequestMapping("/usermanagement")
	public ModelAndView getUserManagement(){
		return new ModelAndView("admin/userManagement");
	}
}
