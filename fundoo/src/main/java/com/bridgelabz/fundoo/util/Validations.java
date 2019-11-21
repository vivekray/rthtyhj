package com.bridgelabz.fundoo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.bridgelabz.fundoo.dto.UserDto;

public class Validations {
	private UserDto user;

	public Validations() {
		user = new UserDto();
	}

	public static String isValidFields(UserDto user) {
		List<Boolean> list = new ArrayList<Boolean>();
		
		String PASSWORD_PATTERN = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		 
		String[] status = {"Invalid FirstName", "Invalid LastName", "Invalid Email-Id", "Invalid Number",
				"Password Should bemix of Alphabet,Symbol and Number with Mainimum 8 disgts"};
		String result="Ok";

		list.add(Pattern.matches("[a-zA-Z]{1,10}", user.getFirstName()));
		list.add(Pattern.matches("[a-zA-Z]{1,10}", user.getLastName()));
		list.add(Pattern.matches("^(.+)@(.+)$", user.getEmail()));
		list.add(Pattern.matches("[789]{1}[0-9]{9}", user.getMobileNumber().toString()));
		list.add(Pattern.matches(PASSWORD_PATTERN , user.getPassword()));
		
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == false) {
                 result=status[i];
                 break;
			}

		}

		return result;
	}

}
