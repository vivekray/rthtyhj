package com.ray.oops;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface service {
	
	
	public String readFile() throws Exception, IOException, ParseException;

	public void buy(int amount,String model);

	public void sell(int amount, String model);
	 public void checkData() throws Exception;

}
