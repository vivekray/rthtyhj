package com.ray.oops.stock.model;

public class SubStock {
	private String name;
	private  long qunatity;
	private  double price;
	public SubStock(){
		name=null;
		qunatity=0;
		price=	0.0d;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQunatity() {
		return qunatity;
	}
	public void setQunatity(long qunatity) {
		this.qunatity = qunatity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
	
