package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;

import com.ugurcanlacin.sportclubsystem.dao.PersonalDetailsDao;
import com.ugurcanlacin.sportclubsystem.model.PersonalDetails;

public class PersonalDetailsDaoImpl extends GenericDaoImpl<PersonalDetails>
		implements PersonalDetailsDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
