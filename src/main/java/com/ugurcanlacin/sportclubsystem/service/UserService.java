package com.ugurcanlacin.sportclubsystem.service;

import java.util.List;

import com.ugurcanlacin.sportclubsystem.model.User;

public interface UserService {
	void mergeUser(User user);
	void persistUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	public User loadUser(String username);
	public List<User> getAllUsers();
	User getUser(String username,String password);
}
