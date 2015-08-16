package com.tuprime.business.user;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.user.UserService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.user.UserDao;
import com.tuprime.entities.User;


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
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

}
