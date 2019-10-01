package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ray.algorithm.Util;

public class InventoryGrain {

	
	//function to write data into JSON file
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void writeGrain(Grain[] grain) throws Exception {
		JSONObject[] jo = new JSONObject[3];
		JSONArray array = new JSONArray();
		for (int i = 0; i < 3; i++) {
			jo[i] = new JSONObject();
			jo[i].put("Grain", grain[i].getGrainName());
			Map m = new LinkedHashMap(3);
			m.put("name", grain[i].ob.getName().toString());
			m.put("weight", grain[i].ob.getWeight());
			m.put("price", grain[i].ob.getPrice());
			jo[i].put("Details:", m);
			array.add(jo[i]);
		}
		PrintWriter pw = new PrintWriter("InventoryGrain.json");

		pw.write(array.toJSONString());

		pw.flush();
		pw.close();

	}

	//function to read data from JSON file
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void readGrains() throws Exception, IOException, ParseException {
		Object obj = Util.readGrain("InventoryGrain.json");

		JSONArray array = (JSONArray) obj;
		JSONObject jo;
		int total=0;
		System.out.println(array);
		for (int i = 0; i < 3; i++) {
			jo = (JSONObject) array.get(i);
			System.out.println(jo);
			System.out.println("Grains::" + (String) jo.get("Grain"));

			Map details = ((Map) jo.get("Details:"));
			System.out.println(details);

			// iterating address Map
			Iterator<Map.Entry> itr = details.entrySet().iterator();
			long w = 0, p = 0;
			while (itr.hasNext()) {

				Map.Entry pair = itr.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());

				if ("weight".equalsIgnoreCase((String) pair.getKey())) {

					w = (long) pair.getValue();
				}

				if ("price".equalsIgnoreCase((String) pair.getKey())) {

					p = (long) pair.getValue();
				}
			}
			System.out.println("Value of Inventory:" + w * p + "\n");
			total=total+(int) (w*p);

		}
		System.out.println("Total value is"+total);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Grain[] ob = new Grain[3];
		InventoryGrain.readGrains();
		System.out.println("Enter the details of Grains::");
		for (int i = 0; i < 3; i++) {
			ob[i] = new Grain();
			System.out.println("Enter the record of " + i + " Record");

			System.out.println("GrainName:");
			// String gname = Util.next();
			ob[i].setGrainName(Util.next());

			System.out.println("Name:");
			// String name = Util.next();
			ob[i].ob.setName(Util.next());

			System.out.println("Weight:");
			// long weight = Util.nextLong();
			ob[i].ob.setWeight(Util.nextLong());

			System.out.println("Price:");
			// long price = Util.nextLong();
			ob[i].ob.setPrice(Util.nextLong());
		}
		// calling function to Write and Read
		InventoryGrain.writeGrain(ob);
		InventoryGrain.readGrains();

	}

}
