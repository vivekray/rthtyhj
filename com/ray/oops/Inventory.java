package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Inventory {

	static void write() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("Inventory", "Rice");

		// for address data, first create LinkedHashMap
		Map m = new LinkedHashMap(3);
		m.put("name", "brown");
		m.put("weight", "10");
		m.put("price", "30");
		jo.put("Details", m);
		PrintWriter pw = new PrintWriter("Inventory.json");
		pw.write(jo.toJSONString());

		pw.flush();
		pw.close();

	}

	static void read() throws Exception {
		Object obj = new JSONParser().parse(new FileReader("Inventory.json"));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting firstName and lastName
		System.out.println("Inventory::" + (String) jo.get("Inventory"));
		// String firstName = (String) jo.get("Inventory");

		Map details = ((Map) jo.get("Details"));

		// iterating address Map
		Iterator<Map.Entry> itr1 = details.entrySet().iterator();
		int w=0,p=0;
		while (itr1.hasNext()) {
			
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			if ("weight".equalsIgnoreCase((String) pair.getKey())) {
                  w=Integer.parseInt((String) pair.getValue());
			}
			if ("price".equalsIgnoreCase((String) pair.getKey())) {
				p=Integer.parseInt((String) pair.getValue());
			}
		}
		System.out.println("Value of Inventory:"+w*p);

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Inventory.write();
		Inventory.read();

	}

}
