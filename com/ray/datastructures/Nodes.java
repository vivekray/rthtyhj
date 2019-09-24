package com.ray.datastructures;

/*public class Nodes {

}*/
public class Nodes
{
	private int data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
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

