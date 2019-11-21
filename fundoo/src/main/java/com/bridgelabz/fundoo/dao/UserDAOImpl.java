package com.bridgelabz.fundoo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.dto.ResetPasswords;
import com.bridgelabz.fundoo.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> getAllUser() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
	}

	@Override
	public User getUserById(Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		User user = currentSession.get(User.class, userId);
		return user;
	}

	@Override
	public int saveUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);

		//if (!isValidUser(user.getEmail())) {
		currentSession.save(user);
		return 1;
	//}
	//	return 0;		
	}

	@Override
	public int deleteUser(Long userId) {
        try {
		Session currentSession = entityManager.unwrap(Session.class);
		User user = currentSession.get(User.class, userId);
		currentSession.delete(user);
		
		return 1;
        } catch (Exception e) {
			// TODO: handle exception
        	return 0;
        }

	}

	@Override
	public void changeStatus(String emailId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			String status = "true";
			int s = 0;		
			s = currentSession.createQuery("update User set isVarify='" + status + "' where email='" + emailId + "'")
					.executeUpdate();
			System.out.println("Varify bro");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValidUser(String email) {
		System.out.println("Hello rays before=================");
		Session currentSession = entityManager.unwrap(Session.class);
	
		System.out.println("Hello rays after=================");
		
		List<User> result = currentSession.createQuery("from User where email='"+email+"'").getResultList();
	
		System.out.println(result.get(0));
		for(User u:result) {
			System.out.println("Email=="+u.getEmail());
		}
		return ((result.isEmpty())) ? false :true;
	}

	@Override
	public boolean userDaoLogin(User user) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		User result = (User) currentSession.createQuery("from User where email='"+user.getEmail()+"'and password='"+user.getPassword()+"'").getResultList();
	     if((result.equals(null))&&result.getIsVarify().equalsIgnoreCase("true")){
	    	 return true;
	     }
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	
	public List<User> checkUser(String email) {
		String activeStatus = "true";
		List<User> result = new ArrayList<>();
		Session currentSession = entityManager.unwrap(Session.class);
		if (isValidUser(email)) {
			result = currentSession.createQuery("from User where isVarify='" + activeStatus+ "'and email='" + email + "'").getResultList();
		}
		return result;
	}
	
	
	@Override
	public int updatePassword(String emailId,ResetPasswords resetPass) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.createQuery("update User set password='" + resetPass.getNewPassword()
				+ "' where email='" + emailId + "'").executeUpdate();
	}

	@Override
	public int isVarify(String email) {
		String activeStatus = "false";
		List<User> result = new ArrayList<>();
		Session currentSession = entityManager.unwrap(Session.class);
		try {
		
		 result = currentSession.createQuery("from User where isVarify='" + activeStatus+ "'and email='" + email + "'").getResultList();
		 System.out.println(result.get(0).getIsVarify());
		 return 1;
		}catch (Exception e) {
			return 0;
		}
	}


}
