package com.tuprime.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.entities.User;


@Controller
public class HomeController {
	
	@RequestMapping(value = { "/", "/admin/login" })
	public ModelAndView getLoginForm() {
		return new ModelAndView("admin/login");
	}
	@RequestMapping(value = { "/redirect", "/qweqwe" })
	public ModelAndView getLoginForm2() {
		return new ModelAndView("common/redirect", "message", "");
	}
}
