package com.tuprime.security;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.tuprime.common.business.admin.AdminService;
import com.tuprime.common.business.user.UserService;
import com.tuprime.common.security.AuthenticationService;
import com.tuprime.entities.Admin;

public class AuthenticationServiceImpl implements AuthenticationService {

	private AdminService adminService;
	private UserService userService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Admin getAuthenticatedAdmin() {
		String adminName = getAuthenticatedUser().getUsername();
		return adminService.loadAdmin(adminName);
	}

	public User getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return (User) authentication.getPrincipal();
	}
	
	public com.tuprime.entities.User getAuthenticatedUserInstance(){
		return userService.loadUser(getAuthenticatedUser().getUsername());
	}


}
