package com.test.test;

public class TestClass {
	public static void main(String[] args) {
		
	}
}

class A implements InterfaceA {
	public void set() {}
}

interface InterfaceA {
	int i = (int) (Math.random() * 10);
	long l = (long) (Math.random() * 10);
	float f = (float) (Math.random() * 10);
	double d = Math.random() * 10;
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

class X {
	@Override
	public String toString() {
		return "xx : " + this;
	}
}