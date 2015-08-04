package com.tuprime.dao.admin;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tuprime.common.dao.admin.AdminDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.Admin;

public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin loadAdmin(String username) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("loadAdmin").setParameter("username", username);
		return (Admin) query.uniqueResult();
	}
}
