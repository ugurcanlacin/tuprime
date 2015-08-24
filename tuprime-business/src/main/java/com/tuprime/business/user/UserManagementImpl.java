package com.tuprime.business.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tuprime.common.business.role.RoleService;
import com.tuprime.common.business.user.ManagementService;
import com.tuprime.common.business.user.UserService;
import com.tuprime.entities.Role;
import com.tuprime.entities.User;
import com.tuprime.common.util.*;

public class UserManagementImpl implements ManagementService{
	
	private UserService userService;
	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User prepareNewUser(User user) {
		return prepareUserToSave(user);
	}
	
	private User prepareUserToSave(User user){
		user.setActive(true);
		user.setCreationTimestamp(new Date());
		user.setState(1);
		user.setPasswordHash(Tool.encrypt(user.getPasswordHash()));
		return setDefaultRole(user);
	}
	
	private User setDefaultRole(User user){
		List<Role> roleList = new ArrayList<Role>();
		Role role = roleService.getRoleByName(RoleNames.ROLE_USER); // ROLE_USER default.
		roleList.add(role);
		user.setRole(roleList);
		return user;
	}

	@Override
	public User prepareUserForEdit(User user) {
		User savedUser = userService.find(user.getId());
		savedUser.setName(user.getName());
		savedUser.setSurname(user.getSurname());
		savedUser.setUsername(user.getUsername());
		savedUser.setEmail(user.getEmail());
		savedUser.setActive(user.isActive());
		return savedUser;
	}
	
	public List<String> getUserRoleList(User user){
		List<String> roleList = new ArrayList<String>();
		for (Role role : user.getRole()) 
			roleList.add(role.getRole());
		return roleList;
	}
	
}
