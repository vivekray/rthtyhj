package com.ray.oops;

public class Grain {
	private String grainName;
	Details ob;

	Grain() {
		grainName = null;
		ob = new Details();
	}

	public void setGrainName(String grainName) {
		this.grainName = grainName;
	}

	public String getGrainName() {
		return this.grainName;

	}

}

class Details {
	private String name;
	private long weight;
	private long price;

	Details() {
		name = null;
		weight = 0L;
		price = 0L;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;

	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getWeight() {
		return this.weight;

	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getPrice() {
		return this.price;

	}

	@Override
	public String toString() {
		return "Details [name=" + name + ", weight=" + weight + ", price=" + price + "]";
	}

}
