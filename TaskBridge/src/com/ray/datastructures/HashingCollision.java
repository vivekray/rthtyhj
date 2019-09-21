package com.ray.datastructures;

import java.io.IOException;

import com.ray.algorithm.Util;
import com.ray.datastructure.OrderedList;

class HNode {
	int data;
	HNode link;

	HNode(int data) {
		this.data = data;
		this.link = null;

	}
}

public class HashingCollision {
	int data;
	HNode head[];
	HashingCollision(int size){
		this.data=data;
		head=new HNode[size];
	}
	
	void add(int data) {
		HNode newNode=new HNode(data);
		int index=data%11;
		newNode.link=null;
		if(head[index]==null) {
			head[index]=newNode;
		}
		else {
			HNode nextNode=head[index];
			while(nextNode.link!=null) {
			nextNode=nextNode.link;
			}
			nextNode.link=newNode;
		}
		
	
	}
	
	public  void  remove(int data) {
		int index=data%11;
		if(head[index]==null) {
			System.out.println("List is emptay");
			return ;
		}
		if(head[index].data==data) {
			head[index]=head[index].link;
		}
		HNode newNode=head[index];
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
	
	public static void printList(HashingCollision list) throws IOException 
    { 
		StringBuffer st=new StringBuffer();
		for(int i=0;i<11;i++) {
			System.out.print("["+i+"]:"+"{");
        HNode currNode = list.head[i]; 
       
   
       // System.out.print("\nLinkedList: \n"); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
            if(i==10) {
            if(currNode.link!=null) {
            	st.append(currNode.data+",");
            }else {
            	st.append(currNode.data);
            }
           }
            else {
            	st.append(currNode.data+",");
            }
          //  st.append(currNode.data+",");
           
            
   
            // Go to next node 
            currNode = currNode.link; 
        } 
        Util.writeFileInt(st.toString());
        System.out.print("}\n");
		}//loop
    } 

	public static void main(String[] args) throws IOException {
		HashingCollision ob=new HashingCollision(11);
		System.out.println("Enter your data");
		int n=Util.nextInt();
		for(int i=0;i<Util.readFileInt().length;i++){
		ob.add(Util.readFileInt()[i]);
		}	
		HashingCollision.printList(ob);
	System.out.println("Enter your data to serach");
		int n1=Util.nextInt();
		ob.remove(n1);
	HashingCollision.printList(ob);
		/*System.out.println("1:Continue");
		int ch=Util.nextInt();
		if(ch==1) {
			System.out.println("Enter your data");
			int n2=Util.nextInt();
			ob.add(n2);
		}
		else {
			System.exit(0);
		}*/
	}
	
	
	

}
