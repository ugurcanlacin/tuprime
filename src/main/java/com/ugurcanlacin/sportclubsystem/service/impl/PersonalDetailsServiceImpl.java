package com.ugurcanlacin.sportclubsystem.service.impl;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.dao.PersonalDetailsDao;
import com.ugurcanlacin.sportclubsystem.model.PersonalDetails;
import com.ugurcanlacin.sportclubsystem.service.PersonalDetailsService;

public class PersonalDetailsServiceImpl extends
		GenericServiceImpl<PersonalDetails> implements PersonalDetailsService {
	PersonalDetailsDao personalDetailsDao;

	public PersonalDetailsDao getPersonalDetailsDao() {
		return personalDetailsDao;
	}

	public void setPersonalDetailsDao(PersonalDetailsDao personalDetailsDao) {
		this.personalDetailsDao = personalDetailsDao;
	}

	@Override
	public GenericDao<PersonalDetails> getDao() {
		return getPersonalDetailsDao();
	}
	
}
