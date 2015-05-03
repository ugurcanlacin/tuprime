package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.List;





import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
	
	private UserService userService;

	
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
