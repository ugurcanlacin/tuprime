package com.tuprime.dao.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tuprime.common.dao.user.UserDao;
import com.tuprime.dao.generic.GenericDaoImpl;
import com.tuprime.entities.User;

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
		u = (User) sessionFactory.getCurrentSession()
				.get(User.class, u.getId());
		if (u.getPasswordHash().equals(password))
			return u;
		else
			return null;
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().getNamedQuery("getAllUsers")
				.list();
	}

	
	public void deleteUser(int id) {
		sessionFactory.getCurrentSession()
				.getNamedQuery("changeState").setParameter("id", id).executeUpdate();
	}

}
