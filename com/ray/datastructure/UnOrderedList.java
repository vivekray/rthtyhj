package com.ray.datastructure;
import java.io.IOException;
import com.ray.algorithm.Util;




class Node1<T> {
	T data;
	Node1 next;

	Node1(T data) {
		this.data = data;
	}
}

 class UnOrderedList<T> {
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
	 
	public static void printList(UnOrderedList<String> list) throws IOException 
    { 
        Node currNode = list.head; 
        StringBuffer st=new StringBuffer();
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
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

 



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		UnOrderedList<String> list=new UnOrderedList<String>();
		String[] value = Util.readFromFile();
		for(String s:value) {
			list.add(s);
		}
		
		
		UnOrderedList.printList(list);
		System.out.println("\nEnter data for search");
		String s1=Util.next();
		list.remove(s1);
		UnOrderedList.printList(list);
		

	}

}
