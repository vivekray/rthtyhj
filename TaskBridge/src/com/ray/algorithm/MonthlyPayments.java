package com.ray.algorithm;

public class MonthlyPayments {
	static float monthlyPayment(int y,int p,int r) {
		int n,r1;
		r1=r/(12*100);
		n=12*y;
		float payment=(float) ((p*r1)/(1-Math.pow((1+r), (-n))));
		
		return payment;
	}
	
	public static void main(String[] args) {
		float f=monthlyPayment(11,100,5);
		System.out.println("Payments is::"+f);
	}

}
