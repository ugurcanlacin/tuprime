package com.tuprime.common.dao.userworkout;

import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.UserDiet;
import com.tuprime.entities.UserWorkout;

public interface UserWorkoutDao extends GenericDao<UserWorkout>{
	public UserWorkout getUserWorkoutByUserAndWorkoutId(int workout_id,int user_id);
}
