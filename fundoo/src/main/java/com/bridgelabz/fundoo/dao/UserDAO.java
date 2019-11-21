package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.dto.ResetPasswords;
import com.bridgelabz.fundoo.model.User;

public interface UserDAO {
	
	List<User> getAllUser();
	User getUserById(Long userId);
	int saveUser(User user);
	int deleteUser(Long userId);
	boolean isValidUser(String emailId);
	void changeStatus(String emailId);
	boolean userDaoLogin(User user);
	List<User> checkUser(String email);
	int updatePassword(String emailId,ResetPasswords user);
    int isVarify(String email);

}
