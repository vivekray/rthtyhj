package com.ray.algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinaryConversion {

	public static int[] readFileInt() throws IOException{
		FileReader fr = new FileReader("numbers.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] word = line.split(" ");
		int[] arr = new int[word.length];
		for(int i=0;i<word.length;i++) {
			arr[i]=Integer.parseInt(word[i]);
		}
		return arr;
		 
		
	}
	static int toBinary(int n) {
		int d, b = 1, s = 0;
		while (n != 0) {
			d = n % 2;
			s = s+ d*b;
			n = n / 2;
			b = b * 10;

		}
		return s;
	}

	static int swapNibbles(int x) {
		return ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
	}

	static boolean isPowerOfTwo(int n) {
		int f = 0;
		while (n != 1) {
			if (n % 2 != 0) {
				f = 1;
				break;
			}
			n = n / 2;

		}
		if (f == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		System.out.println("Conversion is::" + toBinary(7));
		System.out.println("Swaped::" + swapNibbles(8));

		if (isPowerOfTwo(swapNibbles(8))) {
			System.out.println("It is Power of 2");
		} else {
			System.out.println("It is not Power of 2");
		}
		System.out.println("Values from file");
		for(int i=0;i<readFileInt().length;i++) {
			System.out.println("Binary ,SwapNibblesNumber & PowerOf2 of "+readFileInt()[i]+" ::["+toBinary(readFileInt()[i])+","+swapNibbles(readFileInt()[i])+","+(isPowerOfTwo(swapNibbles(readFileInt()[i]))==true?"Yes":"No")+"]");
			
		}

	}

}
