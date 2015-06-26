package com.ugurcanlacin.sportclubsystem.dao.impl;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.RoleDao;
import com.ugurcanlacin.sportclubsystem.model.Role;

@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

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

	public List<Role> getAllRoles() {
		return sessionFactory.getCurrentSession().getNamedQuery("getAllRoles")
				.list();
	}

	public Role getRoleByName(String roleName) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("getRoleByName").setParameter("role", roleName);
		return (Role)query.uniqueResult();
	}
}
