package com.ray.datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.ray.algorithm.Util;

class SlotMap {
	
	
    	public static int[] readFileInt() throws IOException{
    		FileReader fr = new FileReader("numbers.txt");
    		BufferedReader br = new BufferedReader(fr);
    		String line = br.readLine();
    		String[] word = line.split(" ");
    		int[] arr = new int[word.length];
    		for(int i=0;i<word.length;i++) {
    			arr[i]=Integer.parseInt(word[i]);
    		}
    		return (Util.insertionSortInt(arr));
    }
    	void add() throws IOException {
    		ArrayList<ArrayList> slot = new ArrayList<ArrayList>();
    		//ArrayList<Integer>[] ar=new ArrayList[10];
    		LinkedList[] list=new LinkedList[10];
    		for(int i=0;i<readFileInt().length;i++) {
    			int n=(readFileInt()[i])%11;
    			//slot.add(n,ar[n].add(readFileInt()[i]));
    			slot.add(n,list[i].add(readFileInt()[i]));
    			
    			
    		}
    		System.out.println(slot);
    	}
    }

public class Hashings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SlotMap ob=new SlotMap();
		ob.add();
	}

}
