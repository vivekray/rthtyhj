
public class Distance {
	private static int x,x1,y,y1;
	
	
	Distance(){
		x1=0;
		y1=0;
	}
	
	 
	static void distance(int x,int y) {
		int dis;
		dis=(int) Math.sqrt((Math.pow((x-x1), 2)+Math.pow((y-y1), 2)));
		System.out.println("The Distance is::"+dis);
		
		
	}

	public static void main(String[] args) {
		
		x=Integer.parseInt(args[0]);
		y=Integer.parseInt(args[1]);
		distance(x,y);

	}

}
