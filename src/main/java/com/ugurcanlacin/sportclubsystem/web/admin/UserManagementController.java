package com.ugurcanlacin.sportclubsystem.web.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@Controller
@RequestMapping("/admin/usermanagement")
public class UserManagementController {
	
	@Resource(name="userService")
	UserService userService;
		
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView viewAddUserPage(){
		User userForm = new User();
		ModelAndView model = new ModelAndView("admin/addUser");
		model.addObject("userForm", userForm);
		return model;
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView proccessAddUser(@ModelAttribute("userForm") User user){
		ModelAndView model =new ModelAndView("admin/addUserResult");
		user.setActive(true);
		try {
			userService.persist(user);
			model.addObject("result", "Registration Succeeded!");
		} catch (Exception e) {
			model.addObject("result", "Registration Failed!");
		}
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id){
		User user = userService.find(id);
		try {
			userService.delete(user);
		} catch (Exception e) {
			
		}
		return "redirect:/admin/usermanagement";
	}
	
	
}
