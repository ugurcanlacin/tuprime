package com.tuprime.business.generic;


import org.springframework.transaction.annotation.Transactional;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.common.dao.generic.GenericDao;


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
