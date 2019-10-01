package com.ray.oops;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InventryStock {
	
	static void write() throws Exception {

		JSONObject[] jo = new JSONObject[30];
		JSONArray array=new JSONArray();
		for(int i=0;i<30;i++) {
			jo[i] = new JSONObject();
		jo[i].put("Stock", "Vivek");

		// for address data, first create LinkedHashMap
		Map m = new LinkedHashMap(3);
		m.put("symbol", "brown");
		m.put("nos", "10");
		m.put("date", "30-12-2019");
		jo[i].put("CompanyShare", m);
		array.add(jo[i]);
		}
		
		
		PrintWriter pw = new PrintWriter("StockInventory.json");
		pw.write(array.toJSONString());

		pw.flush();
		pw.close();

	}

	
	
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		write();

	}

}
