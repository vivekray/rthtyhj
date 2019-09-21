import java.util.Scanner;

public class LeapYear {
	
	static void leap(int year)
	{
		boolean b=false;
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
				{
					b=true;
				}
				else
				{
					b=false;
				}
			}
			else 
			{
				b=true;
			}
			
		}
		else
		{
			b=false;
		}
		if(b)
		{
			System.out.println(year+"  is  leap year");
		}
		else
		{
			System.out.println(year+" is not  leap year");
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the Year to check");
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		leap(year);

	}

}
