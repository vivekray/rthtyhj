package com.ray.oops;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UserDetails {
	private static String name;
	private static String fullName;
	private static String phoneNumber;
	//private static LocalDate dates;
	private static Date date;
	
	UserDetails(){
		name=null;
		fullName=null;
		phoneNumber=null;
		//date=null;
		date=new Date();
		//dates=LocalDate.now();
		
	}
	
	
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public  void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public static String getDate() {
	
		   return (new SimpleDateFormat("dd/MM/yyyy").format(date)).toString();
	
	}
	public static void setDate() {
		//dates=LocalDate.now();
		date=new Date();
	}
	
	

}
