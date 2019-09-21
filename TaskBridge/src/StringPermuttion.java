import java.util.Scanner;

public class StringPermuttion {
    private static String str;
    private static int c=-1;
	
    StringPermuttion(){
		str=null;
	}
    static int check(String s,String s2) {
    	if(s.equalsIgnoreCase(s2)) {
    		c++;
    	}
	
    	return c;
    }
    static void swap(char[] c,int i,int j) {
    	char temp=c[i];
    	c[i]=c[j];
    	c[j]=temp;
    }
	
	void getString() {
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		int l=str.length();
		System.out.println("Possible Permuted values are::");
		generatePermut(str.toCharArray(),0);
		
	}

	static void generatePermut(char[] s,int index) {
		
		if(index==s.length-1) {
		System.out.println(String.valueOf(s));
		
		c=check(str,String.valueOf(s));
		
		}
		for(int i=index;i<s.length;i++) {
			swap(s,index,i);
			generatePermut(s,index+1);
			swap(s,index,i);
		}
		
		
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermuttion ob=new StringPermuttion();
		System.out.println("Enter String value");
		ob.getString();
		System.out.println("Value of Matching String is::"+c);
		

	}

}
