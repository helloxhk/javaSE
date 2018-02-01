package com.test.test;

public class TestClass {
	public static void main(String[] args) {
//		System.out.println(AbstractA.PI);
//		System.out.println(FinalA.B);
//		System.out.println(InterfaceA.i);
//		System.out.println(InterfaceA.l);
//		System.out.println(InterfaceA.f);
//		System.out.println(InterfaceA.f);
//		System.out.println(InterfaceA.d);
//		System.out.println(InterfaceA.d);
//		A a = new A();
//		System.out.println(a.i);
//		System.out.println(a.l);
//		System.out.println(a.f);
//		System.out.println(a.d);
	}
}

class A implements InterfaceA {
	@Override
	public void set() {
	}
}

interface InterfaceA {
	int i = (int) (Math.random() * 10);
	long l = (long) (Math.random() * 10);
	float f = (float) (Math.random() * 10);
	double d = (Math.random() * 10);
	void set();
}

abstract class AbstractA {
	public static final double PI = 3.14;
	public AbstractA(int i) {
	}
}

class C extends AbstractA {
	public C(int i) {
		super(i);
	}
	private class X {
		
	}
}

final class FinalA {
	public static final String B = "HELLO WORLD!"; 
}

