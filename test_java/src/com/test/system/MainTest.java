package com.test.system;

public class MainTest {

	public static void main(String[] args) {
//		System.out.println(new Date().toLocaleString());
//		Properties props = System.getProperties();
//		props.list(System.out);
//		
//		System.out.println("=============================");
//		System.out.println();
//		
//		System.out.println("Memory useage ");
//		
//		Runtime runtime = Runtime.getRuntime();
//		
//		System.out.println("总内存：" + runtime.totalMemory());
//		
//		System.out.println("剩余内存：" + runtime.freeMemory());
//		try {
//			Thread.currentThread().sleep(5 * 1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		int x = 1, y = 2, z = 3;
//		System.out.println("hello" + x + y + z);
//		System.out.println(Integer.MAX_VALUE);
		A a = new A();
		a.say().say().say();
		
	}

}

class A {
	public A() {
		super();
	}

	public A(int i) {
		this();
	}

	public A say() {
		//
		return this;
	}
}
