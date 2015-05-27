package com.ugurcanlacin.sportclubsystem.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.GenericDao;

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
		type = (Class)pt.getActualTypeArguments()[0];
		
	}
	public void persist(T o) {
		getCurrentSession().persist(o);
	}

	public T find(Integer id) {
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
