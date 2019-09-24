package com.ray.datastructures;

import javax.naming.directory.NoSuchAttributeException;

import com.ray.utilty.Util;

public class check {
	private int[] q;
	private int front;
	private int rear;

	public check() {
		q = new int[10];
		front = -1;
		rear = -1;
	}

	public check(int maxsize) {
		q = new int[maxsize];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return (front == -1 || front == rear + 1);
	}

	public boolean isFull() {
		return (rear == q.length - 1);
	}

	public int size() {
		if (isEmpty())
			return 0;
		else
			return rear - front + 1;

	}
	public void insert(int x) {
		if(isFull()) {
			System.out.println("Queue overflow\n");
		}
		if(front==-1)
			front=0;
		rear=rear+1;
		q[rear]=x;
	}
	
	public int delete() throws NoSuchAttributeException {
		int x;
		if(isEmpty()) {
			System.out.println("Queue overflow\n");
			throw new NoSuchAttributeException();
		}
		x=q [front];
		front=front+1;
		return x;
		
	}
	public int peek() throws NoSuchAttributeException {
		if(isEmpty()) {
			System.out.println("Queue overflow\n");
			throw new NoSuchAttributeException();
		}
		return q[front];
	}
	public void display() {
		int i;
		if(isEmpty()) {
			System.out.println("Empty");
			return;
		}
		System.out.println("Queue is::\n\n");
		for(i=front;i<rear;i++) {
			System.out.println(q[i]+" ");
			
		}
		System.out.println("");
	}

	public static void main(String[] args) throws NoSuchAttributeException {
		// TODO Auto-generated method stub
		check ob=new check(8);
		int n;
		System.out.println("Enter your Choice");
		while(true) {
			System.out.println("Enter your Choice");
			System.out.println("1:Insert");
			System.out.println("2:delete");
			System.out.println("3:front element");
			System.out.println("4:display");
			System.out.println("5:size of element");
			System.out.println("6:exit");
			int ch=Util.nextInt();
			switch(ch) {
			case 1:System.out.println("Insert element");
			 n=Util.nextInt();
			ob.insert(n);
			break;
			case 2:System.out.println("Deleted Elements::"+ob.delete());
			break;

			case 3:System.out.println("front Elements::"+ob.peek());
			case 4:ob.display();
			break;
			case 5:System.out.println("front Elements::"+ob.size());
		     break;
		     
			}
		}

	}

}
