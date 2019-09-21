import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coupon {
	
	public static void couponNumbers(int n,int[] arr)
	{

		 Random ob=new Random();
		 int[] c = new int[10];
		 int max=999,min=100;
		 boolean b=false;
		 for(int i=1;i<=n;i++)
		 {
			 int j=0;
			 int num=0,count=0;
			
			 
			 while(j!=arr[i])
			 {
				 num=j;
				 count++;
				 j=ob.nextInt((max-min)+1)+min;
			 }
			 System.out.println(arr[i]+" is Matched After "+count+" time search");
		 }
		
		
		 
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int[] arr=new int[10];
		System.out.println("Enter Number Coupon");
		int c=sc.nextInt();
		System.out.println("Enter "+c+" coupons");
		for(int i=1;i<=c;i++)
		{
			arr[i]=sc.nextInt();
			
			if(arr[i]>100&&arr[i]<=999)
			{
				continue;
			}
			else
			{
				System.out.println("Please provide 4 digit +ve Numbers");
				break;
			}
			
		}
		couponNumbers(c,arr);
		
		}


}
