package com.ugurcanlacin.sportclubsystem.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.UserDao;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Transactional
	public void persistUser(User user) {
		userDao.persistUser(user);
	}
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	@Transactional
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	@Transactional
	public User loadUser(String username) {
		return userDao.loadUser(username);
	}
	@Transactional
	public UserDao getUserDao() {
		return userDao;
	}
	@Transactional
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
