package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.ray.algorithm.Util;

public class serviceImpliments implements service {
	public static void writeFile(StockAccaunt[] ob) throws IOException, ParseException, Exception {
		JSONArray array=new JSONArray(); 
		JSONObject jo;
		for(StockAccaunt ob1:ob) {
		jo = new JSONObject();
		jo.put("Brand", ob1.getName());
		Map m = new LinkedHashMap();
		SubStockAccount sb = ob1.getList().get(0);
		m.put("name", sb.getName());
		m.put("Quantity", sb.getQunatity());
		m.put("Price", sb.getPrice());
		jo.put("Details", m);
		array.add(jo);
		}
		

		
		
		PrintWriter pw = new PrintWriter("StockAccountManagement.json");
		pw.write(array.toJSONString());
		pw.flush();
		pw.close();

		System.out.println("Added Successfully");
		//String s = (new serviceImpliments()).readFile();

		return;
	}

	public String readFile() throws Exception, IOException, ParseException {
		Object obj = Util.readGrain("StockAccountManagement.json");
		
		JSONArray array = (JSONArray) obj;
		JSONObject ob;
		StockAccaunt st;
		for(int i=0;i<array.size();i++) {
			
			ob=(JSONObject) array.get(i);
			//System.out.println(s[i]);
			   
		System.out.println("Brand:"+(String)ob.get("Brand"));
		Map details = ((Map) ob.get("Details"));
		
		Iterator<Map.Entry> itr1 = details.entrySet().iterator();
		long q=0;
		double p=0;
		while (itr1.hasNext()) {

			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			if("Price".equalsIgnoreCase((String) pair.getKey())) {
				p=(double)pair.getValue();
				
			}
			if("Quantity".equalsIgnoreCase((String) pair.getKey())) {
				q=(long)pair.getValue();
				
			}
			
		}
		System.out.println("Total Amaount::"+p*q+"\n");
		}
		return null;
	}

	public void buy(int ampount, String model) {
		SubStockAccount ob = new SubStockAccount();

	}

	public void sell(int ampount, String model) {
	}

	@Override
	public void checkData() throws Exception{
		Object obj = Util.readGrain("StockAccountManagement.json");
		JSONObject jo = (JSONObject) obj;
		
		System.out.println("Brand:" + jo.get("Brand"));
		if("Mahindra".equalsIgnoreCase((String) jo.get("Brand"))) {
			System.out.println("It is mahindra");
		}

		
	}

}
