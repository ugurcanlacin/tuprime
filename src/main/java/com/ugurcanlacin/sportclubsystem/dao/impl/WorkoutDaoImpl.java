package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.dao.WorkoutDao;

public class WorkoutDaoImpl implements WorkoutDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
