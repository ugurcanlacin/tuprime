package com.tuprime.dao.personaldetails;


import org.hibernate.SessionFactory;

import com.tuprime.common.dao.personaldetails.PersonalDetailsDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.PersonalDetails;


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
