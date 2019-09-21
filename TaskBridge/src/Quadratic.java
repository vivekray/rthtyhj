import java.util.Scanner;

public class Quadratic {
    private static	double delta,sq,x1,x2;
	
	
	 static void getValue(float a,float b, float c) {
		 if(a==0) {
			 System.out.println("Invlid value of a");
			 System.exit(0);
		 }
		 delta=b*b-4*a*c;
		 sq=Math.sqrt((Math.abs(delta)))/(2*a);
	
		 if(delta<0) {
			 System.out.println("Roots are Imaginary:");
			 System.out.println("Roots 1: "+(-b/2*a)+"  "+sq+"i");
			 System.out.println("Roots 2: "+(-b/2*a)+" "+(-sq)+"i");
	      }
		 else {
			 System.out.println("Roots are Real:");
			 System.out.println("Roots 1:  "+((-b/(2*a))+sq));
			 System.out.println("Roots 2: "+((-b/(2*a))-sq));
			 
		 }
			 
		
		
	}
	 
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		float a,b,c;
		System.out.println("Enter the value of Qudratic");
		System.out.println("Enter the value of a");
		a=sc.nextInt();
		System.out.println("Enter the value of b");
		b=sc.nextInt();
		System.out.println("Enter the value of c");
		c=sc.nextInt();
		getValue(a,b,c);

	}

}
