import java.util.Random;
import java.util.Scanner;

public class HeadTail {

public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
     Random ob=new Random();
    float i;
    int t=0,h=0;
  
    System.out.println("Enter the number of term");
    int c=sc.nextInt();
    for(int j=1;j<=c;j++)
    {
    	 i=ob.nextFloat();
    	 if(i<0.5)
    	 {
    		 t++;
    	 }
    	 else
    	 {
    		h++; 
    	 }
    	
    }
    
    System.out.println("Percentage of Tails:"+(float)(t*100/c));
    System.out.println("Percentage of heads:"+(float)(h*100/c));
    
}
}
