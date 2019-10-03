package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.ray.algorithm.Util;

public class StockMain {

	public static void main(String[] args) throws IOException, ParseException, Exception {
		
		// TODO Auto-generated method stub
		String s = (new serviceImpliments()).readFile();
		System.out.println("Enter Your Number of brand");
		int value=Util.nextInt();
		StockAccaunt[] objmain=new StockAccaunt[value];
		for(int i=0;i<value;i++)
		{
		
		System.out.println("Enter Your "+(i)+" Brand");
		objmain[i]=new StockAccaunt();
		System.out.println("Enter The name of Brand");
		String name=Util.next();
		System.out.println("Enter The name of model");
		String model=Util.next();
		System.out.println("Enter The quantity");
		int qunt=Util.nextInt();
		System.out.println("Enter The price");
		double price=Util.nextDouble();
		objmain[i].setName(name);
	    objmain[i].setList(model,qunt, price);
		}
		serviceImpliments.writeFile(objmain);
	    //System.out.println("What do you want");
	    //System.out.println("\n1:Add\n2:Report");
	    
	  
		
	}

}
