package com.ugurcanlacin.sportclubsystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.UserDao;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.util.Tool;

@Transactional
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User loadUser(String username) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("loadUser").setParameter("username", username);
		return (User) query.uniqueResult();
	}

	public User getUser(String username, String password) {
		User u = loadUser(username);
		u = (User) sessionFactory.getCurrentSession().get(User.class, u.getId());
		if(u.getPasswordHash().equals(password))
			return u;
		else
			return null;
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().getNamedQuery("getAllUsers").list();
	}



	
}
