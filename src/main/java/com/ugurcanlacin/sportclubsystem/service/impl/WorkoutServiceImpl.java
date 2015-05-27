package com.ugurcanlacin.sportclubsystem.service.impl;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.dao.WorkoutDao;
import com.ugurcanlacin.sportclubsystem.model.Workout;
import com.ugurcanlacin.sportclubsystem.service.WorkoutService;

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
