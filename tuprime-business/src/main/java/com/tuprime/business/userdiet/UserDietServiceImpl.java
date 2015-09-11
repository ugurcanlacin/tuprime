package com.tuprime.business.userdiet;

import java.util.List;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.userdiet.UserDietService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.userdiet.UserDietDao;
import com.tuprime.entities.UserDiet;

public class UserDietServiceImpl extends GenericServiceImpl<UserDiet> implements UserDietService{

	private UserDietDao userDietDao;
	
	public UserDietDao getUserDietDao() {
		return userDietDao;
	}
	public void setUserDietDao(UserDietDao userDietDao) {
		this.userDietDao = userDietDao;
	}

	@Override
	public GenericDao<UserDiet> getDao() {
		return getUserDietDao();
	}
	@Override
	public List<UserDiet> getUserDietListByUserId(int userId) {
		return userDietDao.getUserDietListByUserId(userId);
	}

}
