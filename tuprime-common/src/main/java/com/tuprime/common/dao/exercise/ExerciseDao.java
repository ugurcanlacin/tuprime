package com.tuprime.common.dao.exercise;

import java.util.List;

import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Exercise;

public interface ExerciseDao extends GenericDao<Exercise>{
	public List<Exercise> getAllExercises();
}
