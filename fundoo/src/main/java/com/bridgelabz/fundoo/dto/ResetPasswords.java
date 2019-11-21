package com.bridgelabz.fundoo.dto;

import lombok.Data;

//@Data
public class ResetPasswords {
	private String newPassword;
 public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


}
