package com.ray.oops;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.parser.ParseException;

import com.ray.algorithm.Util;

public class StockAccaunt {
	private String name;
	ArrayList<SubStockAccount> list;
	
	StockAccaunt() throws IOException, ParseException, Exception{
		name=null;
		list=new ArrayList<SubStockAccount>();
		String s=(new serviceImpliments()).readFile();
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<SubStockAccount> getList() {
		return list;
	}
	public void setList(String model,int qunt,double price) {
		SubStockAccount ob=new SubStockAccount();
		ob.setName(model);
		ob.setQunatity(qunt);
		ob.setPrice(price);
		this.list.add(ob);
	}

	
}

