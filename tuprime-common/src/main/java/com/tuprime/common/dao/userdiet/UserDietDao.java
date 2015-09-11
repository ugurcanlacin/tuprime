package com.tuprime.common.dao.userdiet;

import java.util.List;

import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.UserDiet;

public interface UserDietDao extends GenericDao<UserDiet>{
	public List<UserDiet> getUserDietListByUserId(int userId);
}
