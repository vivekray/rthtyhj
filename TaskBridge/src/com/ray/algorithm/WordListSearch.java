package com.ray.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordListSearch {

	static boolean serachWord(String s) throws IOException {
	    FileReader fr = new FileReader("C:\\Users\\Rays\\Desktop\\input.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] word = line.split(",");
		
		System.out.println("List from File::");
		for (String str : word) {
			System.out.print(str+" ");
		}
		Arrays.sort(word);
		
		if (Util.binarySearchString(word, s)) {
			return true;
		} else {
			return false;
		}

		

	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the word to be searched");
		String str = Util.next();
		if (serachWord(str)) {
			System.out.println("\n\nYes!! Word is found");
		} else {
			System.out.println("\n\nSorry!! Notfound");
		}

	}

}
