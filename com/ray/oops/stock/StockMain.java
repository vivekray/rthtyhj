package com.ray.oops.stock;

import com.ray.oops.stock.control.ServicesImplement;

public class StockMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilStockLinkedList<Integer> lists= new UtilStockLinkedList<Integer>();
		//lists.add(1);
		//lists.add(2);
		//lists.add(3);
		//lists.add(4);
		//lists.display();
		
		ServicesImplement ob1=new ServicesImplement();
		ob1.read();
	

	}

}
