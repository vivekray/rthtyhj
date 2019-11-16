package com.crudusinghibernate.service;

import java.util.List;

import javax.mail.MessagingException;

import com.crudusinghibernate.dto.UserDto;
import com.crudusinghibernate.model.User;

public interface UserService {
	

	List<User> getAllUser();
	User getUserById(int userId);
	int saveUser(UserDto user) throws MessagingException;
	void deleteUser(int userId);
	 boolean verifyUser(String fromGeneratedToken);
	 void sendEmail(String url, String generatedToken) throws MessagingException ;

}
