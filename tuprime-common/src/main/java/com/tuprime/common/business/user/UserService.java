package com.tuprime.common.business.user;


import java.util.List;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.User;


public interface UserService extends GenericService<User>{
	

	public User loadUser(String username);
	public List<User> getAllUsers();
	User getUser(String username,String password);
}
