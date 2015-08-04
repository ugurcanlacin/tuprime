package com.tuprime.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.entities.User;

@Controller
public class UserController {

	@RequestMapping(value = { "/dashboard", "/404" })
	public ModelAndView getLoginForm() {
	
		return new ModelAndView("common/404", "message", "hosgeldin");
	}
	@RequestMapping("/user/dashboard")
	public ModelAndView getLoginFor2m() {
	
		return new ModelAndView("user/index", "message", "hosgeldin");
	}
}
