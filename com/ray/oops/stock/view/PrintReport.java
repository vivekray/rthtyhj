package com.ray.oops.stock.view;

import com.ray.oops.stock.UtilStockLinkedList;
import com.ray.oops.stock.model.Stock;

public class PrintReport {
	 private  SNode head;
	 static class SNode<T> {
			T data;
			SNode link;

			SNode(T data) {
				this.data = data;
				this.link = null;

			}
		}
	public  void display(UtilStockLinkedList<Stock> list) {
		System.out.println("Reports Are");
		list.display();
		
		}
		
	}


