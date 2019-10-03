 package com.ray.oops.stock.model;

public class Stock {
	private String name;
	SubStock ob;
	public SubStock getOb() {
		ob.getName();
		ob.getQunatity();
		ob.getPrice();
		return ob;
	}

	public void setOb(SubStock ob) {
		SubStock ob1 = new SubStock();
		ob1.setName(ob.getName());
		ob1.setQunatity(ob.getQunatity());
		ob1.setPrice(ob.getPrice());
		this.ob = ob1;
	}

	public Stock(){
		name=null;
		ob=new SubStock();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
