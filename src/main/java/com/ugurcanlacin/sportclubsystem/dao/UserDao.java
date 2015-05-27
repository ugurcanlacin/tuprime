package com.ugurcanlacin.sportclubsystem.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.model.User;


public interface UserDao extends GenericDao<User>{
	public User loadUser(String username);
	public List<User> getAllUsers();
	User getUser(String username,String password);
}
