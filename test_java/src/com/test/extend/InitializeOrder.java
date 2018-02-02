package com.test.extend;

/**
 * 测试继承关系下的初始化顺序
 * @author xhk
 *
 */
public class InitializeOrder {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		D d = new D();
	}
}

class A {
	static {
		System.out.println("static A	3");
	}
	public A() {
		System.out.println("A	4");
	}
}

class B {
	static {
		System.out.println("static B	6");
	}
	public B() {
		System.out.println("B	7");
	}
}

class C {
	static {
		System.out.println("static C	1");
	}
	A a = new A();
	public C() {
		System.out.println("C	5");
	}
	
	public void set(){};
}

class D extends C {
	static {
		System.out.println("static D	2");
	}
	B b = new B();
	public D() {
		System.out.println("D	8");
	}
	public void set(){};
}