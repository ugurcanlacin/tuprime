package com.tuprime.business.userworkout;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.userworkout.UserWorkoutService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.userworkout.UserWorkoutDao;
import com.tuprime.entities.UserWorkout;

public class UserWorkoutServiceImpl extends GenericServiceImpl<UserWorkout> implements UserWorkoutService{

	private UserWorkoutDao userWorkoutDao;
	
	public UserWorkoutDao getUserWorkoutDao() {
		return userWorkoutDao;
	}

	public void setUserWorkoutDao(UserWorkoutDao userWorkoutDao) {
		this.userWorkoutDao = userWorkoutDao;
	}

	@Override
	public GenericDao<UserWorkout> getDao() {
		return getUserWorkoutDao();
	}

	@Override
	public UserWorkout getUserWorkoutByUserAndWorkoutId(int workout_id,
			int user_id) {
		return userWorkoutDao.getUserWorkoutByUserAndWorkoutId(workout_id, user_id);
	}

}
