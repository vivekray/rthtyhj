package com.ray.algorithm;

public class Tempture {

	static float tempratureConevert(float t) {
		System.out.println("In which form you want convert");
		System.out.println("1:Celcius   2:Fahrenheit");
		int in = Util.nextInt();
		float f = 0;
		
		if (in == 1) {
			f = ((t - 32) * 5) / 9;
		} else if (in == 2) {
			f = 9 * t / 5 + 32;
		} else {
			System.out.println("Invalid option");
			System.exit(0);
		}

		return f;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		System.out.println("Enter your Value");
		float f=Util.nextFloat();
		System.out.println(Util.tempratureConevert(f));

	}

}
