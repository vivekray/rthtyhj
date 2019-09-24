package com.ray.datastructures;

import com.ray.utilty.Util;

class QNode{
	Customer data;
	QNode next;
	public QNode(Customer data) {
		this.data=data;
		this.next=null;
	}
}


class Queue{
	QNode front,rear;
	Queue(){
		this.front=this.rear=null;
	}
	
	void enqueue(Customer data) {
		QNode temp=new QNode(data);
		if (this.rear == null) { 
            this.front = this.rear = temp; 
          
            return; 
        } 
  
        // Add the new node at the end of queue and change rear 
        this.rear.next = temp; 
        this.rear = temp; 
	}
	// QNode dequeue()
	void dequeue()
	    { 
	        // If queue is empty, return NULL. 
	        if (this.front == null) 
	            //return null;
	        	System.out.println("List is empty");
	  
	        // Store previous front and move front one node ahead 
	        QNode temp = this.front; 
	        this.front = this.front.next; 
	  
	        // If front becomes NULL, then change rear also as NULL 
	        if (this.front == null) 
	            this.rear = null; 
	        //return temp.;
	        System.out.println("Customer is Deleted");
	    } 
	 public  int size() {
		 int size = 1;
		 QNode temp=front;
		 while(temp.next!=null) {
			 temp=temp.next;
			 size++;
		 }
		 return size;
	 }
	
}

public class BankQueue {

	public static void main(String[] args) {
		
		Queue ob=new Queue();
		Customer data=new Customer();
		int amount,choice;
		//System.out.println("Enter your Choice");
		while(true) {
			System.out.println("Enter your Choice");
			System.out.println("1:insert");
			System.out.println("2:delete");
			System.out.println("3:size of Customer");
			/*System.out.println("3:front element");
			System.out.println("4:display");
			System.out.println("5:size of element");*/
			System.out.println("6:exit");
			int ch=Util.nextInt();
			switch(ch) {
			case 1:System.out.println("Insert Amount ");
			 amount=Util.nextInt();
			 System.out.println("1:Deposit");
			 System.out.println("2:Withdraw");
			 choice=Util.nextInt();
			 if(choice==1) {
				 data.deposit(amount);
				 data.display();
			 }else if(choice==2) {
				 data.withdraw(amount);
				 data.display();
				 
			 }else {
				 System.out.println("Invalid");
				 break;
			 }
				 ob.enqueue(data);
			break;
			case 2://System.out.println("Deleted Elements::"+ob.dequeue());
				ob.dequeue();
			break;

			/*case 3:System.out.println("front Elements::"+ob.peek());
			case 4:ob.display();
			break;*/
			case 3:System.out.println("Customer Number::"+ob.size());
		     break;
		     
			}
		}
		// TODO Auto-generated method stub

	}

}
