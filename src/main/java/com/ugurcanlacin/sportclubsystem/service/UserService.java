package com.ugurcanlacin.sportclubsystem.service;

import java.util.List;

import com.ugurcanlacin.sportclubsystem.model.User;

public interface UserService extends GenericService<User>{
	

	public User loadUser(String username);
	public List<User> getAllUsers();
	User getUser(String username,String password);
}
