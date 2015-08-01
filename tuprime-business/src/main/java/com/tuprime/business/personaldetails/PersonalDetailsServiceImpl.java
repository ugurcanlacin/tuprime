package com.tuprime.business.personaldetails;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.personaldetails.PersonalDetailsService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.personaldetails.PersonalDetailsDao;
import com.tuprime.entities.PersonalDetails;


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
