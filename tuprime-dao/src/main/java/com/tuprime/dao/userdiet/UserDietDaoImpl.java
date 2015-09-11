package com.tuprime.dao.userdiet;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tuprime.common.dao.userdiet.UserDietDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.UserDiet;

public class UserDietDaoImpl extends GenericDaoImpl<UserDiet> implements UserDietDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<UserDiet> getUserDietListByUserId(int userId) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("getUserDietListByUserId").setParameter("id", userId);
		return query.list();
	}

}
