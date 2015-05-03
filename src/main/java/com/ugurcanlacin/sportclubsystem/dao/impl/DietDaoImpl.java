package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.dao.DietDao;
import com.ugurcanlacin.sportclubsystem.model.Diet;

public class DietDaoImpl implements DietDao{
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persistDiet(Diet diet) {
		sessionFactory.getCurrentSession().persist(diet);
	}

	public void updateDiet(Diet diet) {
		sessionFactory.getCurrentSession().update(diet);
	}

	public void deleteDiet(Diet diet) {
		sessionFactory.getCurrentSession().delete(diet);
	}
}
