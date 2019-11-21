package com.bridgelabz.fundoo.util;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.fundoo.dto.UserDto;
import com.bridgelabz.fundoo.model.User;

public class Utility {

	public static User userDtoToEntity(UserDto userDto) {
		if(userDto!=null) {
		User user = new User();
       user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setIsVarify("false");
		LocalDateTime date=LocalDateTime.now();
		user.setCreatedTime(date);

		return user;
		}
		else
		{
			return null;
		}
	}

	
	
	@SuppressWarnings("static-access")
	public static UserDto entityToUserDto(User user) {
		if(user!=null) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword("**************");
		userDto.setMobileNumber(user.getMobileNumber());
		userDto.setCreatedTime(user.getCreatedTime());
		return userDto;
		}
		else {
			return null;
		
		}
	}
	
	 public static List<UserDto>  userDtoConvertList(List<User> userList) {
		 List<UserDto> list=new LinkedList<UserDto>();
		 for(User user:userList)
			list.add(entityToUserDto(user));
		 
		return (List<UserDto>)list;
	 }
	 
	 public static List<User>  userConvertList(List<UserDto> userDtoList) {
		 List<User> list=new LinkedList<User>();
		 for(UserDto userDto:userDtoList)
			list.add(userDtoToEntity(userDto));
		 
		return list;
	 }

	
	
	
	
}
