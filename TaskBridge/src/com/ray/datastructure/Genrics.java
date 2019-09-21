package com.ray.datastructure;
import java.io.IOException;
import java.util.ArrayList;

import com.ray.algorithm.Util;

class Node<T> {
	T data;
	Node next;

	Node(T data) {
		this.data = data;
	}
}

class LinkedList<T> {
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
	public  void  remove(T data) {
		if(head==null) {
			System.out.println("List is emptay");
			return ;
		}
		if(head.data.equals(data)) {
			head=head.next;
		}
		Node newNode=head;
		while((newNode.next!=null)) {
			if((newNode.next.data).equals(data)) {
				break;
			}
			newNode=newNode.next;
			
		}
		if(newNode.next==null) {
			System.out.println("Added and Saved");
			add(data);
		}
		else {
			newNode.next=newNode.next.next;
		}
		
		
	}
	 
	
	public static void printList(LinkedList list) throws IOException 
    { 
        Node currNode = list.head; 
        StringBuffer st=new StringBuffer();
   
        System.out.print("LinkedList: "); 
   
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
        Util.writeIntoFile(st.toString());
    } 
}
 



public class Genrics<T> {
	T obj;

	Genrics(T obj) {
		this.obj = obj;
	}

	public T get() {
		return obj;

	}
	


	public static void main(String[] args) throws IOException {
		Genrics<String> string = new Genrics<String>("Hello");
		Genrics<Integer> numbers = new Genrics<Integer>(10);
		Genrics<Double> d = new Genrics<Double>(10.9);
		Genrics<Character> c = new Genrics<Character>('h');
		System.out.println("Provided Dtata types tp Genrics is=====" + string.get());
		System.out.println("Provided Dtata types tp Genrics is=====" + numbers.get());
		System.out.println("Provided Dtata types tp Genrics is=====" + d.get());
		System.out.println("Provided Dtata types tp Genrics is=====" + c.get());
		
		
		LinkedList<String> list=new LinkedList<String>();
		String[] value = Util.readFromFile();
		for(String s:value) {
			list.add(s);
		}
		
		
		list.printList(list);
		System.out.println("\nEnter data for search");
		String s1=Util.next();
		list.remove(s1);
		list.printList(list);
		
	}

}
