package com.ray.datastructures;

class RootSolve{
	int n;
	static long ep=(long) 1e-15;
	
	public long solve(int n) {
		long t=n;
		try {
		while((Math.abs(t-n/t)>ep*t)) {
			t=(t-n/t)/2;
			
		}
		}catch(Exception e) {
			
		}
		
		return t;
		
	}
}
public class Newtons {

	public static void main(String[] args) {
		RootSolve ob=new RootSolve();
		
		System.out.println("Valu is::"+ob.solve(5)+"::"+RootSolve.ep);

	}

}
