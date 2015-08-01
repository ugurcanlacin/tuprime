package com.tuprime.dao.diet;


import org.hibernate.SessionFactory;

import com.tuprime.common.dao.diet.DietDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.Diet;


public class DietDaoImpl extends GenericDaoImpl<Diet> implements DietDao{
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
