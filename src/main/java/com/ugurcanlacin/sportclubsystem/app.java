package com.ugurcanlacin.sportclubsystem;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;









import com.ugurcanlacin.sportclubsystem.dao.UserDao;
import com.ugurcanlacin.sportclubsystem.dao.impl.UserDaoImpl;
import com.ugurcanlacin.sportclubsystem.model.Role;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.model.Workout;
import com.ugurcanlacin.sportclubsystem.service.UserService;
import com.ugurcanlacin.sportclubsystem.util.Tool;




public class app {
	private static SessionFactory sessionFactory ;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<User> listUser = session.getNamedQuery("getAllUsers").list();
		for (User user : listUser) {
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
		context.close();

	}
}
/*
User user = new User("asd", "asd", "asd", "asd", true, null);
user.setActivationHash("as");
Role role= (Role) session.get(Role.class,1);
List rList = new ArrayList<E>();
rList.add(role);
user.setRole(rList);
session.save(user);
*/