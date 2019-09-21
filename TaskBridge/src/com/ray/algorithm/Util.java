package com.ray.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	///StopWatch time class
	public static class StopWatch {
		private static long startt;
		private static long stopp;
		static long start()
		{
		 startt=System.currentTimeMillis();
		 return startt;
		 
		}
		 static long stop()
		{
		 stopp=System.currentTimeMillis();
		return stopp;
		}
		static void gap(long start,long stop)
		 {
			 long h,x,m,s;
			 x=stop-start;
			  h = x / (60*60*1000);
			  x = x - h*(60*60*1000);
		      m = x / (60*1000);
		      x = x - m*(60*1000);
			  s = x / 1000;
			  x = x - s*1000;
			  System.out.println("Duration:"+h+":"+m+":"+s);
					    
			     
		 }
	}
	
	
	/*File Reads functions for String*/
	
	public static String[] readFromFile() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\Rays\\Desktop\\input1.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] word = line.split(",");

		return word;
	}
	/*File Reads functions for Integer*/
	
	public static int[] readFileInt() throws IOException{
		//FileReader fr = new FileReader("C:\\Users\\Rays\\Desktop\\input2.txt");
		FileReader fr = new FileReader("HashNumbers.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] word = line.split(",");
		int[] arr = new int[word.length];
		for(int i=0;i<word.length;i++) {
			arr[i]=Integer.parseInt(word[i]);
			//System.out.println(arr[i]);
		}
		return arr;
		
		
	}
	/*File Writes functions for String*/
public static void writeIntoFile(String str) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Rays\\Desktop\\input1.txt"));
		bw.write(str);
		bw.flush();
		bw.close();

	}
	
/*Fie writes functions for Integer*/
public static void writeFileInt(String numbers) throws IOException {
	//BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Rays\\Desktop\\input2.txt"));
	BufferedWriter bw = new BufferedWriter(new FileWriter("HashNumbers.txt"));
	bw.write(numbers);
	bw.flush();
	bw.close();
	}

//////////////////////////////////

	static Scanner scanner = new Scanner(java.lang.System.in);

	public static int nextInt() {
		return scanner.nextInt();
	}

	public static String next() {
		return scanner.next();
	}

	public static float nextFloat() {
		return scanner.nextFloat();
	}

	public static double nextDouble() {
		return scanner.nextDouble();
	}

	//////
	public static boolean polin(int x) {
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

	////////////////////////////////////////////////////
	public static boolean prime(int num) {
		boolean b = true;
		if (num == 0 || num == 1 || num == 2) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {

					b = false;
				}
			}

		}
		return b;

	}

///////////////////////////////////////Searching/////////////////////////////
	static boolean binarySearchInt(int[] numbers, int b) {
		int[] arr=insertionSortInt(numbers) ;
		if (arr.length == 0) {
			return false;
		}
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int middle = (low + high) / 2;
			if (b > arr[middle]) {
				low = middle + 1;
			} else if (b < arr[middle]) {
				high = middle - 1;
			} else { // The element has been found
				return true;
			}
		}
		return false;
	}

	static boolean binarySearchString(String[] word, String x) {
			String[] str=insertionSortString(word) ;
		if (str.length == 0) {
			return false;
		}
		int l = 0;
		int r = str.length - 1;

		while (l <= r) {
			int middle = (l + r) / 2;
			int res = x.compareTo(str[middle]);
			if (res>0) {
				l = middle + 1;
			} else if (r<0) {
				r = middle - 1;
			} else { // The element has been found
				return true;
			}
		}
		return false;

	}

	//////////////////////////////////////////// Sort////////////////
	public static int[] insertionSortInt(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	static String[] insertionSortString(String[] str) {
		String temp = "";
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].compareToIgnoreCase(str[j]) > 0) {
					temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		return str;
	}

	////////////////////

	public static int[] bubbleSortInt(int[] arr) {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

	static String[] bubbleSortString(String[] str) {
		int n = str.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (str[j].compareToIgnoreCase(str[j + 1]) > 0) {

					String temp = str[j];
					str[j] = str[j + 1];
					str[j + 1] = temp;
				}
		return str;
	}

	
	////////////////////
	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static int[] sorting(int arr[],int l,int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second half
			sorting(arr, l, m);
			sorting(arr, m + 1, r);

			// Merge the sorted half
			merge(arr, l, m, r);
		}
		return arr;
		}
	 static int[] mergeSortInt(int[] arr) {
		 
		return (sorting(arr,0,arr.length-1));
		 
	 }
	/////////////////////Merge String////////////
		static void mergeString(String[] str, int l, int m, int r) {

			int n1 = m - l + 1;
			int n2 = r - m;

			String L[] = new String[n1];
			String R[] = new String[n2];

			for (int i = 0; i < n1; ++i)
				L[i] = str[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = str[m + 1 + j];

			int i = 0, j = 0;

			int k = l;
			while (i < n1 && j < n2) {
				int res=L[i].compareTo(R[j]);
				if (res<0) {
					str[k] = L[i];
					i++;
				} else {
					str[k] = R[j];
					j++;
				}
				k++;
			}

			while (i < n1) {
				str[k] = L[i];
				i++;
				k++;
			}

			while (j < n2) {
				str[k] = R[j];
				j++;
				k++;
			}
		}

		static String[] sortingString(String[] str,int l,int r) {
			if (l < r) {
				// Find the middle point
				int m = (l + r) / 2;

				// Sort first and second half
				sortingString(str, l, m);
				sortingString(str, m + 1, r);

				// Merge the sorted half
				mergeString(str, l, m, r);
			}
			return str;
		}
		 static String[] mergeSortString(String[] str) {
			 
			return (sortingString(str,0,str.length-1));
			 
		 }
	 
	 /////Conevrtion of tempratures
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
	
		 

}
