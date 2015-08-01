package com.tuprime.business.workout;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.workout.WorkoutService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.workout.WorkoutDao;
import com.tuprime.entities.Workout;


public class WorkoutServiceImpl extends GenericServiceImpl<Workout> implements
		WorkoutService {

	WorkoutDao workoutDao;
	
	
	public WorkoutDao getWorkoutDao() {
		return workoutDao;
	}


	public void setWorkoutDao(WorkoutDao workoutDao) {
		this.workoutDao = workoutDao;
	}


	@Override
	public GenericDao<Workout> getDao() {
		return getWorkoutDao();
	}

}
