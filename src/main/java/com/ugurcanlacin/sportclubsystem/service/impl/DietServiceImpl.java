package com.ugurcanlacin.sportclubsystem.service.impl;

import com.ugurcanlacin.sportclubsystem.dao.DietDao;
import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.model.Diet;
import com.ugurcanlacin.sportclubsystem.service.DietService;

public class DietServiceImpl extends GenericServiceImpl<Diet> implements DietService{

	private DietDao dietDao;
	

	public DietDao getDietDao() {
		return dietDao;
	}

	public void setDietDao(DietDao dietDao) {
		this.dietDao = dietDao;
	}

	@Override
	public GenericDao<Diet> getDao() {
		return getDietDao();
	}

	
}
