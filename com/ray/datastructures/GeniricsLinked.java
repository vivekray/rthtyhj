package com.ray.datastructures;

public interface GeniricsLinked<E>{
	void push(E v);
	E pop();
	E peek();
	boolean isEmpty();

}
