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
	public ModelAndView getLoginForm(@ModelAttribute User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("admin/login2", "message", message);
	}
	@RequestMapping(value = { "/redirect", "/qweqwe" })
	public ModelAndView getLoginForm2() {
		return new ModelAndView("common/redirect", "message", "");
	}
}
