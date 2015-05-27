package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.RoleDao;
import com.ugurcanlacin.sportclubsystem.model.Role;

@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Role getRoleById(int id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
