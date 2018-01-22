package com.test.enums.trafficlight;

public class FlyWeight {
	public static void main(String[] args) {
		Integer i1 = -128;
		Integer i2 = -128;
		System.out.println(i1 == i2); // false
		
		Integer i3 = 127;
		Integer i4 = 127;
		System.out.println(i3 == i4); // true
		
		// -128 - 127 之间的数
	}
}
