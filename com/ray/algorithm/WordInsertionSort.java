package com.ray.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordInsertionSort {

	static String[] readFromFile() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\Rays\\Desktop\\input.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] word = line.split(",");

		return word;
	}

	static void printArrayInt(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	static void printArrayString(String[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] str = { "vivek", "helo", "ajaha", "jhhd", "ray" };
		int[] arr = { 1, 4, 3, 4, 5, 6, 32, 98, 11 };
		long start=Util.StopWatch.start();
		printArrayString(Util.insertionSortString(str));
		long start1=Util.StopWatch.start();
		
		System.out.println("Duration::"+(start1-start));

		printArrayString(Util.insertionSortString(readFromFile()));
		long start2=Util.StopWatch.start();
		System.out.println("Duration::"+(start2-start1));

		printArrayInt(Util.insertionSortInt(arr));
		long start3=Util.StopWatch.start();
		System.out.println("Duration::"+(start3-start2));

		printArrayInt(Util.bubbleSortInt(arr));
		long start4=Util.StopWatch.start();
		System.out.println("Duration::"+(start4-start3));
		
		
		printArrayString(Util.bubbleSortString(str));
		long start5=Util.StopWatch.start();
		System.out.println("Duration::"+(start5-start4));
		
		printArrayString(readFromFile());
		printArrayInt(Util.mergeSortInt(arr));
		printArrayString(Util.mergeSortString(readFromFile()));
		long start6=Util.StopWatch.start();
		System.out.println("Duration::"+(start6-start5));

		System.out.println("Size are===============" + readFromFile().length);
		String[] s = readFromFile();
		if (Util.binarySearchString(readFromFile(), "vivek")) {
			System.out.println("Its found");

		} else {
			System.out.println("not found");
		}

	}

}
