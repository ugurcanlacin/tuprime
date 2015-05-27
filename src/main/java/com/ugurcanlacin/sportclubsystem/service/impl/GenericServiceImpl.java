package com.ugurcanlacin.sportclubsystem.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;
import com.ugurcanlacin.sportclubsystem.dao.UserDao;
import com.ugurcanlacin.sportclubsystem.service.GenericService;

@Transactional
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	
	public abstract GenericDao<T> getDao();
	
	public void persist(T o) {
		getDao().persist(o);
	}	

	public T find(Integer id) {
		return getDao().find(id);
	}

	public void update(T o) {
		getDao().update(o);
	}

	public void delete(T o) {
		getDao().delete(o);
	}

	public void merge(T o) {
		getDao().merge(o);
	}
	
	

}
