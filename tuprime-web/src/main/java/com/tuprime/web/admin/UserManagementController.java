package com.tuprime.web.admin;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.role.RoleService;
import com.tuprime.common.business.user.UserService;
import com.tuprime.entities.Role;
import com.tuprime.entities.User;
import com.tuprime.web.util.*;


@Controller
@RequestMapping("/admin/usermanagement")
public class UserManagementController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "roleService")
	private RoleService roleService;

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

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView viewAddUserPage() {
		User userForm = new User();
		ModelAndView model = new ModelAndView("admin/addUser");
		model.addObject("userForm", userForm);
		return model;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView proccessAddUser(@ModelAttribute("userForm") User user) {
		ModelAndView model = new ModelAndView("admin/addUserResult");
		user.setActive(true);
		user.setCreationTimestamp(new Date());
		List<Role> roleList = new ArrayList<Role>();
		Role role = roleService.getRoleByName(RoleNames.ROLE_USER); // ROLE_USER default.
		roleList.add(role);
		user.setRole(roleList);
		String password = Tool.encrypt(user.getPasswordHash());
		user.setPasswordHash(password);
		try {
			userService.merge(user);
			model.addObject("result", "Registration Succeeded!");
		} catch (Exception e) {
			model.addObject("result", "Registration Failed!");
		}
		model.addObject("userForm", user);
		return model;
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/admin/usermanagement";
	}

	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id") int id) {
		User userForm = userService.find(id);
		ModelAndView model = new ModelAndView("admin/editUser");
		model.addObject("userForm", userForm);
		return model;
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.POST)
	public ModelAndView editUserProccess(@ModelAttribute("userForm") User user) {
		ModelAndView model = new ModelAndView("admin/editUserResult");
		User currentUser = userService.find(user.getId());
		currentUser.setName(user.getName());
		currentUser.setSurname(user.getSurname());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());
		currentUser.setActive(user.isActive());
		
		//name,surname,username,email,active
		try {
			userService.update(currentUser);
			model.addObject("result", "Edit Succeeded!");
		} catch (Exception e) {
			model.addObject("result", "Edit Failed!");
		}
		model.addObject("userForm", user);
		return model;
	}

	@RequestMapping(value = "role", method = RequestMethod.GET)
	public ModelAndView roleManagement() {
		ModelAndView model = new ModelAndView("admin/role");
		List<User> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);
		return model;
	}

	@RequestMapping(value = "/editrole/{id}", method = RequestMethod.GET)
	public ModelAndView selectUserForRole(@PathVariable("id") int id) {
		User userForm = userService.find(id);
		ModelAndView model = new ModelAndView("admin/editrole");
		model.addObject("userForm", userForm);
		model.addObject("roles", roleService.getAllRoles());
		List<String> roleList = new ArrayList<String>();
		List<Role> userRoleList = userForm.getRole();
		for (Role role : userRoleList) {
			roleList.add(role.getRole());
		}
		model.addObject("usersroleList", roleList);
		return model;
	}

	@RequestMapping(value = "/editrole", method = RequestMethod.POST)
	public ModelAndView editRoleProccess(
			@ModelAttribute("userForm") User user,
			@RequestParam(required = false, value = "ROLE_USER") Boolean roleUser,
			@RequestParam(required = false, value = "ROLE_ADMIN") Boolean roleAdmin,
			@RequestParam(required = false, value = "ROLE_TRAINER") Boolean roleTrainer) {
		ModelAndView model = new ModelAndView("admin/editroleresult");
		user = userService.find(user.getId());
		List<Role> roleList = new ArrayList<Role>();
		if(roleUser != null && roleUser == true){
			roleList.add(roleService.getRoleByName(RoleNames.ROLE_USER));
		}
		if(roleAdmin != null && roleAdmin == true){
			roleList.add(roleService.getRoleByName(RoleNames.ROLE_ADMIN));
		}
		if(roleTrainer != null && roleTrainer == true){
			roleList.add(roleService.getRoleByName(RoleNames.ROLE_TRAINER));
		}
		user.setRole(roleList);
		try {
			userService.merge(user);
			model.addObject("result", "Role settings were recorded.");
		} catch (Exception e) {
			model.addObject("result", "Role settings failed.");
		}
		model.addObject("userForm", user);
		return model;
	}

}
