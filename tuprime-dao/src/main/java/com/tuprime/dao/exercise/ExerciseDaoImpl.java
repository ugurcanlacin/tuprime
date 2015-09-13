package com.tuprime.dao.exercise;

import java.util.List;

import org.hibernate.SessionFactory;

import com.tuprime.common.dao.exercise.ExerciseDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.Exercise;

public class ExerciseDaoImpl extends GenericDaoImpl<Exercise> implements ExerciseDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Exercise> getAllExercises() {
		return sessionFactory.getCurrentSession().getNamedQuery("getAllExercises")
				.list();
	}

}
