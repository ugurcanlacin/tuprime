package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ugurcanlacin.sportclubsystem.application.AuthenticationService;
import com.ugurcanlacin.sportclubsystem.model.Role;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;
import com.ugurcanlacin.sportclubsystem.util.RoleNames;
import com.ugurcanlacin.sportclubsystem.util.Tool;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private UserService userService;
	private String username;
	private String password;
	private AuthenticationService authenticationService;

	public String login() {
		boolean success = false;
		User user = userService.getUser(username, Tool.encrypt(password));
		
		if (user != null) {
			success = authenticationService.login(username,
					Tool.encrypt(password));
		} else {
			System.out.println("Incorrect informations...");
		}
		if (success) {
			return getPage(user);

		} else {
			FacesContext.getCurrentInstance()
					.addMessage(
							"loginForm:error",new FacesMessage("Login or password incorrect.")
							);
			return "login.xhtml";
		}
	}

	
	public String getPage(User user){
		
		List<Role> rl = user.getRole();
		List<String> roles = new ArrayList<String>();
		for (Role role : rl) {
			roles.add(role.getRole());
		}
		if(roles.contains(RoleNames.ROLE_ADMIN))
			return "/pages/admin/index.xhtml";
		else if(roles.contains(RoleNames.ROLE_TRAINER))
			return "/pages/trainer/index.xhtml";
		else
			return "/pages/user/index.xhtml";
	}
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(
			AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

}
