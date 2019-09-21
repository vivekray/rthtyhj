import java.util.Scanner;

public class StringReplace {
	
	static void replace(String s)
	{
		System.out.println("User Name is  "+s+" which is replaced");
	}
	
	
	
	
	public static void main(String[] args)
	
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Value with min 3 Character for Replaced");
		String s=sc.next();
		if(s.length()<3)
		{
			System.out.println("Min 3 char");
		}
		else
		{
			replace(s);
		}
		
	}
	
	

}
