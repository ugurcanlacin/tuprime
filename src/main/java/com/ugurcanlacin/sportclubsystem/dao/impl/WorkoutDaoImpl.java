package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.dao.WorkoutDao;
import com.ugurcanlacin.sportclubsystem.model.Workout;
import com.ugurcanlacin.sportclubsystem.service.impl.GenericServiceImpl;

public class WorkoutDaoImpl extends GenericDaoImpl<Workout> implements WorkoutDao{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
