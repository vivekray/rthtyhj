package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ray.algorithm.Util;

class StockPortFolio {
	private Stock stock;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public static void writeIntoJSON() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		jo.put("Stock ManageMents", "Stock");

		// for address data, first create LinkedHashMap
		Map m = new LinkedHashMap(3);
		m.put("name", "brown");
		m.put("NumberOfShare", "10");
		m.put("Price", "30");
		jo.put("Details", m);
		PrintWriter pw = new PrintWriter("Stocks.json");
		pw.write(jo.toJSONString());

		pw.flush();
		pw.close();
		}
	
public static void read() throws FileNotFoundException, IOException, ParseException {
	Object obj = Util.readGrain("Stocks.json");

	// typecasting obj to JSONObject
	JSONObject jo = (JSONObject) obj;

	// getting firstName and lastName
	System.out.println("Stock ManageMents::\n" + (String) jo.get("Stock ManageMents"));
	// String firstName = (String) jo.get("Inventory");

	Map details = ((Map) jo.get("Details"));

	// iterating address Map
	Iterator<Map.Entry> itr1 = details.entrySet().iterator();
	int no=0,p=0;
	while (itr1.hasNext()) {
		
		Map.Entry pair = itr1.next();
		System.out.println(pair.getKey() + " : " + pair.getValue());
		if ("NumberOfShare".equalsIgnoreCase((String) pair.getKey())) {
              no=Integer.parseInt((String) pair.getValue());
		}
		if ("price".equalsIgnoreCase((String) pair.getKey())) {
			p=Integer.parseInt((String) pair.getValue());
		}
	}
	System.out.println("Value of Inventory:"+no*p);

}
	
		

	
	

	 public static void  main(String[] args) throws Exception {
		 writeIntoJSON() ;
		 read();
		 
	 }
 }
