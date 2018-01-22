package com.test.enums.trafficlight;

public class TestA {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		String str1 = "abc";
		Class clazz1 = String.class;
		Class clazz2 = str1.getClass();
		Class clazz3 = Class.forName("java.lang.String");
		clazz3.getPackage();
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz1 == clazz3);
		System.out.println(clazz1.isPrimitive());
		System.out.println(int.class == Integer.TYPE);
		System.out.println(int[].class.isPrimitive());
		System.out.println(int[].class.isArray());
		
	}
}
