package com.tuprime.common.dao.user;


import java.util.List;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.User;

public interface UserDao extends GenericDao<User>{
	public User loadUser(String username);
	public List<User> getAllUsers();
	User getUser(String username,String password);
}
