package com.ray.datastructures;

import java.util.EmptyStackException;

public class GenricsClass<E> implements GeniricsLinked<E> {
	 public GenricsClass() {
		 top=null;
	 }
	 private static class Element<E>{
		 private E data;
		 private Element<E> next;
		 Element(E data,Element next){
			 this.data=data;
			 this.next=next;
		 }
	 }
    private Element<E> top;
	@Override
	public void push(E v) {
		if(v==null) {
			throw new NullPointerException();
		}
		
	}

	@Override
	public E pop() {
		// 
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		E data=top.data;
		top=top.next;
		return data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();	
		}
		E data=top.data;
		return data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return(top==null);
		//return false;
	}
}
