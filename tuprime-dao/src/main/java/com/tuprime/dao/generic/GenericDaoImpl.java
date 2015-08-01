package com.tuprime.dao.generic;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tuprime.common.dao.generic.GenericDao;


@Transactional
public abstract class GenericDaoImpl <T>  implements GenericDao<T>{

	private Class<T> type;
	
	public abstract SessionFactory getSessionFactory();
	
	protected Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	public GenericDaoImpl(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)t;
		type = (Class)pt.getActualTypeArguments()[0];   // What is the point of this??
		
	}
	public void persist(T o) {
		getCurrentSession().persist(o);
	}

	public T find(Integer id) {
		@SuppressWarnings("unchecked")
		T o = (T) getCurrentSession().get(type, id);
		return o;
	}

	public void update(T o) {
		getCurrentSession().update(o);
	}

	public void delete(T o) {
		getCurrentSession().delete(o);
	}

	public void merge(T o) {
		getCurrentSession().merge(o);
	}

}
