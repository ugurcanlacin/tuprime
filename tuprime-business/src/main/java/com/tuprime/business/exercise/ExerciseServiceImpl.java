package com.tuprime.business.exercise;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.exercise.ExerciseService;
import com.tuprime.common.dao.exercise.ExerciseDao;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Exercise;

public class ExerciseServiceImpl extends GenericServiceImpl<Exercise> implements ExerciseService{

	private ExerciseDao exerciseDao;
	
	public ExerciseDao getExerciseDao() {
		return exerciseDao;
	}

	public void setExerciseDao(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

	@Override
	public GenericDao<Exercise> getDao() {
		return getExerciseDao();
	}

}
