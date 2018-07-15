package com.mt.rough;

import java.util.Date;

public class TimeStamp {
	
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.toString().replace(" ", "-") );
		System.out.println(d.toString().replace(" ", "-").replace(":", "-") + ".jpg" );
	}
	
}
