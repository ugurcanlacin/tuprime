package com.tuprime.common.business.userdiet;

import java.util.List;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.UserDiet;

public interface UserDietService extends GenericService<UserDiet>{
	public List<UserDiet> getUserDietListByUserId(int userId);

}
