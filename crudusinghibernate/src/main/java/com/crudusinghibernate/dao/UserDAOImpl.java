package com.crudusinghibernate.dao;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.crudusinghibernate.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	public List<User> getAllUser() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<User> query=currentSession.createQuery("from users",User.class);
		List<User> userList=query.getResultList();
		return userList;
	}

	@Override
	public User getUserById(int userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class,userId);
		return user;
	}

	@Override
	public int saveUser(User user) {
		Session currentSession=entityManager.unwrap(Session.class);
		
//		if (!isValidUser(user.getEmail())) {
			currentSession.save(user);
			return 1;
//		}
//		return 0;		
	}

	@Override
	public void deleteUser(int userId) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class,userId);
		currentSession.delete(user);
		
		
		
	}
	@Override
	public void changeStatus(String emailId) {
		Session currentSession = entityManager.unwrap(Session.class);
		String status = "true";
		currentSession.createQuery(
				"update users set is_varify='" + status + "' where email='" + emailId + "'")
				.executeUpdate();
	}
	

	
	
	@Override
	public boolean isValidUser(String emailId) {
		Session currentSession = entityManager.unwrap(Session.class);
		List<User> result = currentSession.createQuery("from users where email='" + emailId + "'").getResultList();
		return (result.size() > 0) ? true : false;
	}


}
