package com.ray.utilty;

import java.util.Scanner;

public class Util{
	static Scanner scanner=new Scanner(java.lang.System.in);
	
	public static int nextInt() {
		return scanner.nextInt();
	}
	public static String nextString() {
		return scanner.next();
	}
	public static float nextFloat() {
		return scanner.nextFloat();
	}
	public static double nextDouble() {
		return scanner.nextDouble();
	}
}