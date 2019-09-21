import com.ray.utilty.Util;

public class WindChill {
	float t,v;
	static float w;
	void getValue() {
		System.out.println("Enter ther value of Temprature in Celsious");
		t=Util.nextFloat();
		System.out.println("Enter ther value of Speed in MPH");
		v=Util.nextFloat();
		if(t>50&&(v<3&&v>120)) {
			System.out.println("Invalid Value");
			System.exit(0);
		}
		else {
			calculate(t,v);
		}
		
		
	}
	static void calculate(float t, float v) {
		//Cnverting mph to mps
		/*float mps=(float) (v*0.44704);
		System.out.println("speed in mps"+mps);
		
		//conevrt t to f
		float tf=(float) ((t+32)/(9/5));
		System.out.println("temp in c"+tf);
		
		float sqv=(float) Math.pow(mps, 0.16);
		w=(float) (35.75+(0.6215*tf)+(0.4275*t-35.75)*sqv);
		System.out.println("The Value of WindChill is::"+w);
		
		*/
		/////////////////////////////////////
		float sqv=(float) Math.pow(v, 0.16);
		w=(float) (35.74+(0.6215*t)+(0.4275*t-35.75)*sqv);
		System.out.println("The Value of WindChill is::"+Math.abs(w));
		////////////////////////////////////
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindChill ob=new WindChill();
		ob.getValue();

	}

}
