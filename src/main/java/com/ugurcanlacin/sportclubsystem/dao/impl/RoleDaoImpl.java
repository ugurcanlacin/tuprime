package com.ugurcanlacin.sportclubsystem.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.RoleDao;
import com.ugurcanlacin.sportclubsystem.model.Role;

@Transactional
public class RoleDaoImpl implements RoleDao{

	private SessionFactory sessionFactory;

	
	public void persistRole(Role role) {
		sessionFactory.getCurrentSession().persist(role);
	}

	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Role getRoleById(int id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}
}
