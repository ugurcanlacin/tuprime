package com.tuprime.dao.userworkout;

import org.hibernate.SessionFactory;

import com.tuprime.common.dao.userworkout.UserWorkoutDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.UserWorkout;

public class UserWorkoutDaoImpl extends GenericDaoImpl<UserWorkout> implements UserWorkoutDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
