package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONWriteExample {

	static void JSONWrite() throws FileNotFoundException {
		JSONObject jo = new JSONObject();

		// putting data to JSONObject
		jo.put("firstName", "John");
		jo.put("lastName", "Smith");
		jo.put("age", 25);

		// for address data, first create LinkedHashMap
		Map m = new LinkedHashMap(4);
		m.put("streetAddress", "21 2nd Street");
		m.put("city", "New York");
		m.put("state", "NY");
		m.put("postalCode", 10021);

		// putting address to JSONObject
		jo.put("address", m);

		// for phone numbers, first create JSONArray
		JSONArray ja = new JSONArray();

		m = new LinkedHashMap(2);
		m.put("type", "home");
		m.put("number", "212 555-1234");

		// adding map to list
		ja.add(m);

		m = new LinkedHashMap(2);
		m.put("type", "fax");
		m.put("number", "212 555-1234");

		// adding map to list
		ja.add(m);

		// putting phoneNumbers to JSONObject
		jo.put("phoneNumbers", ja);

		// writing JSON to file:"JSONExample.json" in cwd
		PrintWriter pw = new PrintWriter("JSONExample.json");
		pw.write(jo.toJSONString());

		pw.flush();
		pw.close();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void JSONRead() throws Exception {
		Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting firstName and lastName
		String firstName = (String) jo.get("firstName");
		String lastName = (String) jo.get("lastName");

		System.out.print(firstName+" ");
		System.out.println(lastName);

		// getting age
		long age = (long) jo.get("age");
		System.out.println("Age:"+age);

		// getting address
		Map address = ((Map) jo.get("address"));

		// iterating address Map
		Iterator<Map.Entry> itr1 = address.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}

		// getting phoneNumbers
		JSONArray ja = (JSONArray) jo.get("phoneNumbers");

		// iterating phoneNumbers
		Iterator itr2 = ja.iterator();

		while (itr2.hasNext()) {
			itr1 = ((Map) itr2.next()).entrySet().iterator();

			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// creating JSONObject

		JSONWriteExample.JSONWrite();
		JSONWriteExample.JSONRead();

	}
}