/**
 * 
 */
package com.ray.datastructure;

import java.io.IOException;

import com.ray.algorithm.Util;

/*class Node<T> {
	T data;
	Node next;

	Node(T data) {
		this.data = data;
	}
}*/

public class OrderedList<T> {
	
	private T data;
	Node head=null;
	
	public void add(T data) {
		Node newNode=new Node(data);
		newNode.next=null;
		if(head==null) {
			head=newNode;
		}
		else {
			Node nextNode=head;
			while(nextNode.next!=null) {
			nextNode=nextNode.next;
			}
			nextNode.next=newNode;
		}
		
		

	}
	public void addAt(T data,T p) throws IOException {
		Node newNode=head;
		int f=0;
		Node temp =new Node(data);
		temp.next=null;

		while(newNode!=null) {
				
			if(newNode.data==p) {
				f=1;
				System.out.println("hello");
				break;
				
				
			}
			newNode=newNode.next;
         
		}
		if(f==0) {
			System.out.println("Number is not found");
			String[] args;
			System.exit(0);
		}
		if(newNode==null) {
		    newNode.next=temp;
			//System.out.print("Number added at last");
		}else {
			temp.next=newNode.next;
			newNode.next=temp;
		}
		
		
	}
		



	
	public  void  remove(T data) {
		if(head==null) {
			System.out.println("List is emptay");
			return ;
		}
		if(head.data==data) {
			head=head.next;
		}
		Node newNode=head;
		while((newNode.next!=null)) {
			if(newNode.next.data==data) {
				break;
			}
			newNode=newNode.next;
			
		}
		if(newNode.next==null) {
			add(data);
			System.out.println("Added and Saved");
			
		}
		else {
			newNode.next=newNode.next.next;
			System.out.println("Duplicate Number Deleted");
		}
		
		
	}
	 
	public static void printList(OrderedList<Integer> list) throws IOException 
    { 
        Node currNode = list.head; 
       StringBuffer st=new StringBuffer();
   
        System.out.print("\nLinkedList: \n"); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + "   "); 
            if(currNode.next!=null) {
            	st.append(currNode.data+",");
            }else {
            	st.append(currNode.data);
            }
            
           
            
   
            // Go to next node 
            currNode = currNode.next; 
        } 
        Util.writeFileInt(st.toString());
    } 


	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OrderedList<Integer> list=new OrderedList<Integer>();
		int[] arr=Util.bubbleSortInt(Util.readFileInt());
		for(int n:arr) {
			list.add(n);
		}
		OrderedList.printList(list);
		System.out.println("\nEnter data for search");
		int s1=Util.nextInt();
		list.remove(s1);
		OrderedList.printList(list);
		System.out.println("\nEnter postion number and data to add");
		int data=Util.nextInt();
		int pos=Util.nextInt();
		list.addAt(data, pos);
		OrderedList.printList(list);

		System.out.println("\n1:Continue");
		int ch=Util.nextInt();
		if(ch==1) {
			main(args);
		}
		else {
			System.out.println("\n1:Thank You");
			System.exit(0);
		}
	}
 

}