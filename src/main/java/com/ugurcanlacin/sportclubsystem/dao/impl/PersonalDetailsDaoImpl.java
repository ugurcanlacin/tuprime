package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.dao.PersonalDetailsDao;

public class PersonalDetailsDaoImpl implements PersonalDetailsDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
