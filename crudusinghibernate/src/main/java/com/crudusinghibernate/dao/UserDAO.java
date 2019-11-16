package com.crudusinghibernate.dao;

import java.util.List;

import com.crudusinghibernate.model.User;

public interface UserDAO {
	
	List<User> getAllUser();
	User getUserById(int userId);
	int saveUser(User user);
	void deleteUser(int userId);
	public boolean isValidUser(String emailId);
	void changeStatus(String emailId);


}
