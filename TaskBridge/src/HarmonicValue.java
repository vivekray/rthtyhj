import java.util.Scanner;

public class HarmonicValue {
	
	static void harmonicValue(int value)
	{
		double s = 0.0,result=0.0;
		for(int i=1;i<=value;i++)
		{
			s=s+(double)1/i;
			System.out.println(s);
		}
		System.out.println("Value is::"+s);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value for HV");
		int h=sc.nextInt();
		if(h!=0)
		{
			harmonicValue(h);
		}
		else
		{
			System.out.println("Valuse can't 0");
		}

	}

}
