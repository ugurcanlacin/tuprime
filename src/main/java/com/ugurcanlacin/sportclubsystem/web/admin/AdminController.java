package com.ugurcanlacin.sportclubsystem.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView("admin/index");
		return model;
	}
}
