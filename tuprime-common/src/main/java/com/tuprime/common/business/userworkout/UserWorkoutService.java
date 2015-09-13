package com.tuprime.common.business.userworkout;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.UserWorkout;

public interface UserWorkoutService extends GenericService<UserWorkout>{
	public UserWorkout getUserWorkoutByUserAndWorkoutId(int workout_id,int user_id);
}
