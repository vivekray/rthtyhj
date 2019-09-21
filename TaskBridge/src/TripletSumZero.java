import java.util.Scanner;

public class TripletSumZero {
	static Scanner sc = new Scanner(System.in);
	
	private static int[] arr;
	
	static void findTriplets(int[] arr, int n) 
	{ 
	    boolean found = false; 
	  
	    for (int i=0; i<n-2; i++) 
	    { 
	        for (int j=i+1; j<n-1; j++) 
	        { 
	            for (int k=j+1; k<n; k++) 
	            { 
	                if (arr[i]+arr[j]+arr[k] == 0) 
	                { 
	                    System.out.println("Triplets which sum is zero::"+arr[i]+" "+arr[j]+" "+arr[k]); 
	                    found = true; 
	                } 
	            } 
	        } 
	    } 
	  
	  
	    if (found == false) 
	        System.out.println("Trplets sum zero not exist"); 
	  
	} 
	
	static void getInput(int value)
	{
		arr=new int[value];
		  System.out.println("Enter numbers");
		for(int i=0;i<value;i++)
		{
			arr[i]=sc.nextInt();
		}
		int n =arr.length;
		findTriplets(arr, n);
		
	}
	
	

	public static void main(String[] args) {
       
		
		System.out.println("Enter Value Number of value");
		int value =sc.nextInt();
	  
		getInput(value);
		sc.close();

	}

}
