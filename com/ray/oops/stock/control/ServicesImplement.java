package com.ray.oops.stock.control;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ray.algorithm.Util;
import com.ray.oops.stock.UtilStockLinkedList;
import com.ray.oops.stock.model.Stock;
import com.ray.oops.stock.model.SubStock;
import com.ray.oops.stock.view.PrintReport;

public class ServicesImplement implements Services {
	
	public void read() {
		UtilStockLinkedList<Stock> list=new UtilStockLinkedList();
		//LinkedList<Stock> list= new  LinkedList<Stock>();
		Stock st;
		try {
			
			Object obj = Util.readGrain("StockAccountManagement.json");
			JSONArray array = (JSONArray) obj;
			JSONObject ob;
			
			SubStock sbt =new SubStock();
			for (int i = 0; i < array.size(); i++) {
				st = new Stock();
				ob = (JSONObject) array.get(i);
				st.setName((String) ob.get("Brand"));
	
				
				Map details = ((Map) ob.get("Details"));

				
		
				
				
				@SuppressWarnings({ "rawtypes", "unchecked" })
				Iterator<Map.Entry> itr = details.entrySet().iterator();
				
			
				
				while (itr.hasNext()) {
	
					@SuppressWarnings("rawtypes")
					Map.Entry pair = itr.next();
					//System.out.println(pair.getKey() + " : " + pair.getValue());
					if ("name".equalsIgnoreCase((String) pair.getKey())) {

						sbt.setName((String) pair.getValue());
						//System.out.println(sbt.getName());
						
					}

					if ("Quantity".equalsIgnoreCase((String) pair.getKey())) {
				
						sbt.setQunatity((long) pair.getValue());
					
					}

					if ("Price".equalsIgnoreCase((String) pair.getKey())) {

						sbt.setPrice((double) pair.getValue());
					}
				}
			
				st.setOb(sbt);
				list.add(st);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Hello:::::"+e);
			e.printStackTrace();
		}
		new PrintReport().display(list);
         
	}

	public void write() {

	}

	public void buy() {

	}

	public void sell() {

	}

	public void check() {

	}
	public static void display(UtilStockLinkedList<Stock> list) {
		System.out.println("VAlue from list");
		for(int i=0;i<list.size();i++) {
			
			//System.out.println(list.getName()+":");
		//	System.out.println(list.get(i).getOb().getName());
			//System.out.println(list.get(i).getOb().getQunatity());
			//System.out.println(list.get(i).getOb().getPrice());
		}
		
	}
}
