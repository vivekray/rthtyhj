package com.ray.oops;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ray.algorithm.Util;

public class UserModification {
	private static String REGEX_NAME = "<<name>>";
	private static String REGEX_FULLNAME= "<<full name>>";
	private static String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private static String REGEX_DATE = "1/1/2016";

	public static String convertString(UserDetails ob, String message){
		Pattern p = Pattern.compile(REGEX_NAME);
		Matcher m = p.matcher(message); 
		message = m.replaceAll(ob.getName());

		p = Pattern.compile(REGEX_FULLNAME);
		m = p.matcher(message); 
		message = m.replaceAll(ob.getName()+" "+ob.getFullName());

		p = Pattern.compile(REGEX_MOBILE_NO);
		m = p.matcher(message); 
		message = m.replaceAll(ob.getPhoneNumber());

		p = Pattern.compile(REGEX_DATE);
		m = p.matcher(message); 
		message = m.replaceAll((ob.getDate()).toString());

		return message;
	}
	static void valid() throws Exception {
		 UserDetails ob = new UserDetails();
		 String fname,lname,number;
		 
			System.out.println("Enter your name,fullname,number,date");
			System.out.println("First Name");
			fname=Util.next();

			while(!Pattern.matches("[A-Za-z]{3,30}", fname)) {
				System.out.println("Invalid First Name try again");
				System.out.println("First Name");
				fname=Util.next();
			}
			ob.setName(fname);
			System.out.println("Last Name");
			lname=Util.next();
			while(!Pattern.matches("[A-Za-z]{3,30}", lname)) {
				System.out.println("Invalid Last Name try again");
				System.out.println("Last Name");
				fname=Util.next();
			}
			ob.setFullName((lname));
			System.out.println("Number");
			number=Util.next();
			while(!Pattern.matches("[789][0-9]{9}", number)) {
				System.out.println("Invalid Number try again");
				System.out.println("Number");
				fname=Util.next();
			}
			ob.setPhoneNumber(number);
			UserDetails.setDate();
			String file = "userModification.txt";
			String file1="userModificationOverwrite.txt";
			Util.writeIntoFile(convertString(ob,(String) Util.readFromFile(file)), file1);
			//System.out.println((String) Util.readFromFile(file1));
			String[] msg=((String) Util.readFromFile(file1)).split("[\\.,]");
			System.out.println("\nWelcome To BridgeLabz \n");
			for(int i=0;i<msg.length;i++)
			{
				System.out.println(msg[i].replaceAll("   ", "\t\t\t\t\t"));
			}
				
			
		 
	 }
	public static void main(String[] args) throws Exception {
		

		// TODO Auto-generated method stub
		valid();

	}

}
