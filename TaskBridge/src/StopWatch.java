import java.util.Scanner;

public class StopWatch {
	private static long startt;
	private static long stopp;
	 void start()
	{
	 startt=System.currentTimeMillis();
	 
	}
	 void stop()
	{
	 stopp=System.currentTimeMillis();
	}
	 void gap()
	 {
		 long h,x,m,s;
		 x=stopp-startt;
		  h = x / (60*60*1000);
		  x = x - h*(60*60*1000);
	      m = x / (60*1000);
	      x = x - m*(60*1000);
		  s = x / 1000;
		  x = x - s*1000;
		  System.out.println("Duration:"+h+":"+m+":"+s);
				    
		     
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StopWatch ob=new StopWatch();
		System.out.print("1 For start stopwatch");
		int ch=sc.nextInt();
		if(ch==1)
		{
			ob.start();
		}
		
		
		
		System.out.print("1 For stop stopwatch");
		int ch1=sc.nextInt();
		if(ch1==1)
		{
			ob.stop();
			ob.gap();
		}
		
		
		
		

	}

}
