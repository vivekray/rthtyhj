package com.ray.datastructure;

import java.util.NoSuchElementException;

import com.ray.algorithm.Util;
/* Node for accessing and fetching vale for queue */
class NodeQ
{
	protected int data;
    protected NodeQ link;
 
    /*  Constructor  */
    public NodeQ()
    {
        link = null;
        data = 0;
    }  
    
    /* Parameterized Constructor  */
    public NodeQ(int d,NodeQ n)
    {
        data = d;
        link = n;
    }  
    
    /*  Function to set data to current Node  */
   	public void setData(int d)
    {
        data = d;
    }   
    
   	/*  Function to get link to next node  */
   	public NodeQ getLink()
    {
     	return link;
    }  
    
	/*  Function to set link to next Node  */
    public void setLink(NodeQ n)
    {
        link = n;
    }  

    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}

class CashQueue {
	public NodeQ front, rear;
    public int size;
 
    /* Constructor */
    public CashQueue()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }   
    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }    
    
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
        NodeQ node = new NodeQ(data, null);
        if (rear == null)
        {
            front = node;
            rear = node;
        }
        else
        {
            //rear.setLink(node);
        	rear=node;
            //rear = rear.getLink();
        	rear=rear.link;
        }
        size++ ;
    }   
    
    /*  Function to remove front element from the queue */
   	public int remove()
    {
        if (isEmpty())
		{
        	throw new NoSuchElementException("Underflow Exception");
		}
        NodeQ ptr = front;
        front = ptr.getLink();        
        if (front == null)
		{
            rear =null;
			size-- ; 
		}       
        return ptr.getData();
    }    
    
    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (isEmpty())
		{
            throw new NoSuchElementException("Underflow Exception");
		}
        return front.getData();
    }    
    
    /*  Function to display the status of the queue */
    public void display()
    {  
		int ptr1=0;
        System.out.print("Available Balance = ");
        if (size == 0)
        {
            System.out.print("Empty");
            return ;
        }
        NodeQ ptr = front;
        while (ptr != rear.getLink() )
        { 
        	ptr1=ptr1+ptr.getData();
        	System.out.println(ptr1);
            ptr = ptr.getLink();
        }
        System.out.println();        
    }

}

public class CashCounter { 
	public static void main(String args[])
	{ 
		CashQueue q=new CashQueue();
		int ch = 0;
		do
		{ 
			System.out.println();
		   	System.out.println("------------Banking Cash Counter-----------");
		   	System.out.println("1.Deposit");
		   	System.out.println("2.Withdraw");
		   	System.out.println("3.Number of people in the Queue ");
		   	System.out.println("4.Exit");
		   	System.out.println();
		   	System.out.println("Enter your choice: ");
		   	int choice=Util.nextInt();
		   	switch (choice) 
		   	{
		   	case 1:
			   		System.out.println("Enter the amount you want to Deposit");
			   		q.insert(Util.nextInt()); 
			   		q.display();
			   		break;
		   	case 2:
			   		System.out.println("Enter the amount you want to Withdraw ");
					
			   		q.remove();
			   		System.out.println(" Your Available Balance is: "); 
			   		q.display();
			   		break;
			case 3:
					int j=q.getSize();
					System.out.println("The Number of People in Queue is: "+j);			
		   	case 4:
			   		System.exit(0);
		   	default: 
			   		System.out.println("You entered wrong choice");
			   		break;
		   	}
	   	}
		while(ch<5);
	}		
}	
