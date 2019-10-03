package com.ray.oops.stock;

import com.ray.oops.stock.model.Stock;

public class UtilStockLinkedList<T> {
	private T data;
    private SNode head;
	
	 static class SNode<T> {
		T data;
		SNode link;

		SNode(T data) {
			this.data = data;
			this.link = null;

		}
	}
	 
	public UtilStockLinkedList(){
		 head=null;
	 }


	public	void add(T data) {
			SNode newNode=new SNode(data);
			newNode.link=null;
			if(head==null) {
				head=newNode;
			}
			else {
				SNode nextNode=head;
				while(nextNode.link!=null) {
				nextNode=nextNode.link;
				}
				nextNode.link=newNode;
				
			}
			
		
		}
		
		public  void  remove(T data) {
			if(head==null) {
				System.out.println("List is emptay");
				return ;
			}
			if(head.data==data) {
				head=head.link;
			}
			SNode newNode=head;
			while((newNode.link!=null)) {
				if(newNode.link.data==data) {
					break;
				}
				newNode=newNode.link;
				
			}
			if(newNode.link==null) {
				add(data);
				System.out.println("Added and Saved");
				
			}
			else {
				newNode.link=newNode.link.link;
				System.out.println("Duplicate Number Deleted");
			}
			
			
		}
	public int size() {
			int size=0;
			SNode newNode=head;
			while((newNode!=null)) {
				newNode=newNode.link;
				++size;
			}
				
			
			return size;
		}
		public void display() {
			System.out.println(size());
			SNode newNode=head ;
			Stock st=new Stock();
		
			while((newNode!=null)) {
				st=(Stock) newNode.data;
				System.out.println((st.getName()));
				System.out.println(st.getName());
				System.out.println(st.getOb().getName());
				System.out.println(st.getOb().getQunatity());
				System.out.println(st.getOb().getPrice());
				newNode=newNode.link;
				
			}
			
		}

}
