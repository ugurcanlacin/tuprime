package com.tuprime.business.diet;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.diet.DietService;
import com.tuprime.common.dao.diet.DietDao;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Diet;


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
