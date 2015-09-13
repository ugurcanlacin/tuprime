package com.tuprime.common.business.exercise;

import java.util.List;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.Exercise;

public interface ExerciseService extends GenericService<Exercise>{
	public List<Exercise> getAllExercises();
}
