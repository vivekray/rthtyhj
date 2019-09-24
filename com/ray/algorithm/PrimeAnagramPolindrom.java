package com.ray.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeAnagramPolindrom {

	static void prime() {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		int r = 0;
		System.out.println("Prime Numnbers are::");
		for (int a = 0; a < 1000; a++) {
			int i, n;

			String[] s;

			boolean b = true;
			n = a;
			if (n == 0 || n == 1 || n == 2) {
				continue;
			} else {

				for (i = 2; i <= n / 2; i++) {
					if (n % i == 0) {

						b = false;
					}
				}

				if (b) {

					if (r >= 30) {
						System.out.print("\n");
						r = 0;
					}
					r++;
					if (n < 10) {
						System.out.print(n + "   ");

					}
					else{
						if(n>10&&n<99) {
							System.out.print(n + "  ");
						}
						else {
							if(n>100)
							System.out.print(n + " ");
						}
						
					} 
					ar1.add(n);
					if (Util.polin(n)) {
						ar.add(n);

					}

				}
			} // end of else
		} // end of outer loop
		System.out.println("\nPolindrome in Prime Numbers");
		System.out.println(ar);
		anagram(ar1);

	}

	static boolean polin(int x) {
		int num = x, d, sum = 0;
		while (num > 0) {
			d = num % 10;
			sum = sum * 10 + d;
			num = num / 10;
		}
		if (x == sum) {
			return true;
		} else {
			return false;
		}

	}

	static void anagram(ArrayList<Integer> ar) {

		System.out.println("Angram Numbers::");
		for (int i = 3; i < ar.size(); i++) {
			ArrayList<Integer> ar1 = new ArrayList<Integer>();
			boolean b = false;
			int retval = ar.get(i);
			int[] copy = Arrays.copyOf(digitSort(retval, count(retval)), count(retval));
			for (int j = i + 1; j < ar.size(); j++) {
				int retval1 = ar.get(j);
				int[] copy1 = Arrays.copyOf(digitSort(retval1, count(retval1)), count(retval1));

				if (Arrays.equals(copy, copy1)) {
					ar1.add(retval1);
					b = true;
				}

			}
			if (b) {
				if(retval<100) {
					System.out.print("Anagram of " + retval + "  are::  ");
					System.out.println(ar1);
				}
				else {
					System.out.print("Anagram of " + retval + " are::  ");
					System.out.println(ar1);
				}
				
				

			}

			// System.out.println(" ");

		}
	}

	static void display(int a, int b) {

		System.out.print("Angram of " + a + " is==" + b);
	}

	static int count(int n) {
		int d, c = 0;
		while (n > 0) {
			d = n % 10;
			n = n / 10;
			c++;
		}
		return c;
	}

	static int[] digitSort(int n, int size) {
		int[] arr = new int[size];
		int d = 0, x = 0;
		while (n > 0) {
			d = n % 10;
			arr[x] = d;
			n = n / 10;
			x++;

		}
		Arrays.sort(arr);
		return arr;
	}

	public static void main(String[] args) {
		prime();
		// TODO Auto-generated method stub

	}

}
