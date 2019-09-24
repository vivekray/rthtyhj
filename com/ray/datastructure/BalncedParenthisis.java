package com.ray.datastructure;

import com.ray.algorithm.Util;

class StackLogic 
	{
		private int maxSize;
		private long[] stackArray;
		private int top;

		//for size  
		public StackLogic(int s)
		{
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
		}
		//for push   
		public void push(long j)
		{
		stackArray[++top] = j;
		}
		//for pop   
		public long pop() 
		{
		return stackArray[top--];
		}
		//for peek   
		public long peek() 
		{
		return stackArray[top];
		}
		//to check whether stack is empty	   
		public boolean isEmpty()
		{
		return (top == -1);
		}
		//to check whether stack is full	   
		public boolean isFull()
		{
		return (top == maxSize - 1);
		}
	}

	
	public class  BalncedParenthisis
	{
		public static void main(String[] args) 
		{
			System.out.println("Enter max size: ");
			int n=Util.nextInt();		

			/* Creating Stack */
			StackLogic stack = new StackLogic(n);
			System.out.println();
			System.out.println("Parenthesis Matching");
			System.out.println();
			 

			/* Accepting expression */
			System.out.println("Enter expression: ");
			String exp = Util.next();       
			int len = exp.length();
			System.out.println("Matches and Mismatches: ");

			for (int i = 0; i < len; i++)
			{    
			char ch = exp.charAt(i);

				if (ch == '(')
				{
				stack.push(i);
				}
					else if (ch == ')')
					{
						try
						{
						long p = (stack.pop() + 1);
						System.out.println("')' at index "+(i+1)+" matched with '(' at index "+p);
						}
						catch(Exception e)
						{
						System.out.println("')' at index "+(i+1)+" is unmatched");
						}
					}            
				}
			while (!stack.isEmpty() )
			{
			System.out.println("'(' at index "+(stack.pop() +1)+" is unmatched");
			}                          
	    }
	 }


