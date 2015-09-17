package com.tuprime.web.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.userdiet.UserDietService;
import com.tuprime.common.security.AuthenticationService;
import com.tuprime.entities.User;
import com.tuprime.entities.UserDiet;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Resource(name = "authenticationService")
	private AuthenticationService authService;
	
	@Resource(name = "userDietService")
	private UserDietService userDietService;
	
	public AuthenticationService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}
	
	public UserDietService getUserDietService() {
		return userDietService;
	}

	public void setUserDietService(UserDietService userDietService) {
		this.userDietService = userDietService;
	}

	@RequestMapping("/dashboard")
	public ModelAndView getDashboard() {
		User user = authService.getAuthenticatedUserInstance();
		List<UserDiet> userDiet = userDietService
				.getUserDietListByUserId(user.getId());
		return new ModelAndView("user/dashboard","userdiet",userDiet);
	}
	
	@RequestMapping("/workout")
	public ModelAndView getWorkoutPage() {
		User user = authService.getAuthenticatedUserInstance();
		return new ModelAndView("user/workout","userWorkout",user.getUserWorkout());
	}
	@RequestMapping("/pdetail")
	public ModelAndView getPersonalDetailPage() {
		User user = authService.getAuthenticatedUserInstance();
		ModelAndView model = new ModelAndView("user/pdetail","pdetails",user.getPersonalDetails());
		model.addObject("jstest", "1");
		return model;
	}
	
}
