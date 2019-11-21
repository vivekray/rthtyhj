package com.bridgelabz.fundoo.service;

import java.util.List;

import javax.mail.MessagingException;

import com.bridgelabz.fundoo.dto.ResetPasswords;
import com.bridgelabz.fundoo.dto.UserDto;
import com.bridgelabz.fundoo.model.User;

public interface UserService {
	

	List<UserDto> getAllUser();
	UserDto getUserById(Long userId);
	int saveUser(UserDto user) throws MessagingException;
	int deleteUser(Long userId);
	 boolean verifyUser(String fromGeneratedToken);
	 void sendEmail(String url,String toEmail, String generatedToken) throws MessagingException ;
	 boolean loginUser(UserDto userDto);
	 public boolean isUserPresent(String email);
	 boolean forgotPassword(String emailId) throws MessagingException;
	 public int updateUser(String generatedtoken, ResetPasswords passwordReset);
	 String validation(UserDto user);
	 int isVarify(String email);

}
