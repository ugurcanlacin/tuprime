package com.ugurcanlacin.sportclubsystem.service.impl;

import com.ugurcanlacin.sportclubsystem.dao.DietDao;
import com.ugurcanlacin.sportclubsystem.model.Diet;
import com.ugurcanlacin.sportclubsystem.service.DietService;

public class DietServiceImpl implements DietService{

	private DietDao dietDao;
	
	public void persistDiet(Diet diet) {
		dietDao.persistDiet(diet);
	}

	public void updateDiet(Diet diet) {
		dietDao.updateDiet(diet);
	}

	public void deleteDiet(Diet diet) {
		dietDao.deleteDiet(diet);
	}

	public DietDao getDietDao() {
		return dietDao;
	}

	public void setDietDao(DietDao dietDao) {
		this.dietDao = dietDao;
	}

	
}
