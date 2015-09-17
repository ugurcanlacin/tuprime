package com.tuprime.web.admin;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.role.RoleService;
import com.tuprime.common.business.user.ManagementService;
import com.tuprime.common.business.user.UserService;
import com.tuprime.common.security.AuthenticationService;
import com.tuprime.entities.Role;
import com.tuprime.entities.User;
import com.tuprime.web.util.*;


@Controller
@RequestMapping("/admin/usermanagement")
public class UserManagementController {

	private static final Logger logger = Logger.getLogger(UserManagementController.class);
	
	@Resource(name = "authenticationService")
	private AuthenticationService authService;
	
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "roleService")
	private RoleService roleService;
	
	@Resource(name = "userManagement")
	private ManagementService managementService;

	public AuthenticationService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ManagementService getManagementService() {
		return managementService;
	}

	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView getAddUserPage() {
		logger.info(authService.getAuthenticatedAdmin()+" executed getAddUserPage()");
		return new ModelAndView("admin/addUser", "userForm", new User());
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute("userForm") User user) {
		ModelAndView model = new ModelAndView("common/result");
		user = managementService.prepareNewUser(user);
		try {
			userService.merge(user);
			model.addObject("result", "Kayýt baþarýyla tamamlandý!");
		} catch (Exception e) {
			model.addObject("result", "Kayýt baþarýsýz oldu. Lütfen tekrar deneyin.");
		}
		model.addObject("redirectPath", "usermanagement");
		model.addObject("userForm", user);
		logger.info(authService.getAuthenticatedAdmin()+" executed addNewUser()");
		return model;
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String deleteUserById(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		logger.info(authService.getAuthenticatedAdmin()+" executed deleteUserById()");
		return "redirect:/admin/usermanagement";
	}

	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public ModelAndView editUserById(@PathVariable("id") int id) {
		logger.info(authService.getAuthenticatedAdmin()+" executed editUserById()");
		return new ModelAndView("admin/editUser","userForm",userService.find(id));
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.POST)
	public ModelAndView editUserByInstance(@ModelAttribute("userForm") User user) {
		ModelAndView model = new ModelAndView("common/result");
		user = managementService.prepareUserForEdit(user);
		try {
			userService.update(user);
			model.addObject("result", "Güncelleme baþarýyla tamamlandý!");
		} catch (Exception e) {
			model.addObject("result", "Güncelleme tamamlanmadý.Lütfen tekrar deneyiniz.");
		}
		model.addObject("redirectPath", "usermanagement");
		model.addObject("userForm", user);
		logger.info(authService.getAuthenticatedAdmin()+" executed editUserByInstance()");
		return model;
	}

	@RequestMapping(value = "role", method = RequestMethod.GET)
	public ModelAndView getRoleManagementPage() {
		List<User> allUsers = userService.getAllUsers();
		ModelAndView model = new ModelAndView("admin/role","users",allUsers);
		logger.info(authService.getAuthenticatedAdmin()+" executed getRoleManagementPage()");
		return model;
	}

	@RequestMapping(value = "/editrole/{id}", method = RequestMethod.GET)
	public ModelAndView selectUserForRoleManagement(@PathVariable("id") int id) {
		User userForm = userService.find(id);
		ModelAndView model = new ModelAndView("admin/editRole");
		model.addObject("userForm", userForm);
		model.addObject("roles", roleService.getAllRoles());
		model.addObject("usersroleList", managementService.getUserRoleList(userForm));
		logger.info(authService.getAuthenticatedAdmin()+" executed selectUserForRoleManagement()");
		return model;
	}

	@RequestMapping(value = "/editrole", method = RequestMethod.POST)
	public ModelAndView editSelectedUserRole(
			@ModelAttribute("userForm") User user,
			@RequestParam(value="roleArray")String[] roleArray) {
		ModelAndView model = new ModelAndView("common/result");
		user = userService.find(user.getId());
		List<Role> roleList = new ArrayList<Role>();
		for (String role : roleArray) {
			roleList.add(roleService.getRoleByName(role));
		}
		user.setRole(roleList);
		try {
			userService.merge(user);
			model.addObject("result", "Yetki ayarlarý baþarýyla kaydedildi.");
		} catch (Exception e) {
			model.addObject("result", "Yetki ayarlarý kaydý baþarýsýz oldu.Lütfen tekrar deneyiniz.");
		}
		model.addObject("redirectPath", "usermanagement");
		model.addObject("userForm", user);
		logger.info(authService.getAuthenticatedAdmin()+" executed editSelectedUserRole()");
		return model;
	}

}
