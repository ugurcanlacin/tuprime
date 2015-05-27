package com.ugurcanlacin.sportclubsystem.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.dao.UserDao;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.UserService;

public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{

	private UserDao userDao;
	
	
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
	
	@Override
	public GenericDao<User> getDao() {
		return userDao;
	}

}
