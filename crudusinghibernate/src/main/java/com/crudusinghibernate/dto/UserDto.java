package com.crudusinghibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {

	private String firstName;
	private String lastName;
	private Integer mNumber;
	private String email;
	private String password;

	public UserDto() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getmNumber() {
		return mNumber;
	}

	public void setmNumber(Integer mNumber) {
	this.mNumber = mNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}