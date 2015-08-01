package com.tuprime.dao.workout;


import org.hibernate.SessionFactory;

import com.tuprime.common.dao.workout.WorkoutDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.Workout;


public class WorkoutDaoImpl extends GenericDaoImpl<Workout> implements WorkoutDao{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
