package com.ray.algorithm;

import java.util.Arrays;

public class Angram {
	
	void getInput(String ana,String txt) {
		
		if(checkAnagram(ana,txt)) {
			System.out.println("Yes! Angram!!");
		}
		
		else {
			System.out.println("NO! Its Not Angram");
		}
		
		}
	
	static boolean checkAnagram(String angrm,String text) {
		char[] an=angrm.toCharArray();
		char[] tx=text.toCharArray();
		Arrays.sort(an);
		Arrays.sort(tx);
	
		
		if((String.valueOf(an)).equals(String.valueOf(tx))){
			return true;
		}else {
			return false;
		}
		
	
		
	}
	public static void main(String[] args) {
		
		Angram ob=new Angram();
		System.out.println("Enter String Value to check Angram");
		System.out.println("Enter 1 String Value:");
		String text1=Util.next();
		System.out.println("Enter 2 String Value::");
		String text2=Util.next();
		if(text1.length()==text2.length()) {
			ob.getInput(text1, text2);
		}else {
			System.out.println("String should be same length");
			System.exit(0);
		}
		
		
		
	}

}
