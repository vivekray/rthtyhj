package com.ray.algorithm;

import java.util.regex.Pattern;

public class DayOfWeek {

	static void getDate() {
		String valid="(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)";
		String[] day= {"Sunday","Monday","Tuesday","Wen","Thursday","Friday","Saturday"};
		String[] month= {"jan","Feb","March","Aprill","May","Jun","July","August","Sept","Oct","Nov","Dec"};
		System.out.println("Enter the date in mm/dd/yyyy form");
		String  input=Util.next();
		
		if(Pattern.compile(valid).matcher(input).matches()) {
			String[] date=input.split("/");
			int y1,m1,x,d1;
			int m=Integer.parseInt(date[0]);
			int d=Integer.parseInt(date[1]);
			int y=Integer.parseInt(date[2]);
			
			y1=y-(14-m)/12;
			x=y1+y1/4-y1/100+y1/400;
			m1=m+12*((14-m)/12)-2;
			d1=(d+x+(31*m1/12))%7;
			
			System.out.println("Day of Date::"+day[d1]);
			System.out.println("Month of Date::"+month[m1+1]);

		}
		else {
			System.out.println("Invalid date");
			System.exit(0);
		}
		
		
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDate();
	}

}
