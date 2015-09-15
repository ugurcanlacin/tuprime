package com.tuprime.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.entities.User;
import org.apache.log4j.Logger;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = { "/", "/admin/login" })
	public ModelAndView getLoginForm() {
		return new ModelAndView("admin/login");
	}
	@RequestMapping(value = "/redirect")
	public ModelAndView getRedirectPage() {
		return new ModelAndView("common/redirect");
	}
}
