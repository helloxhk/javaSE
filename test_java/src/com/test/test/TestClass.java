package com.test.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

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
		/*Vector<Object> vector = new Vector<>();
		Enumeration<Object> elements = vector.elements();
		while(elements.hasMoreElements()){
			Object obj = elements.nextElement();
			System.out.println(obj);
		}
		List<Object> list = new ArrayList<>();
		Iterator<Object> iterator = list.iterator();
		if(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println(obj);
		}*/
//		X x = new X();
//		System.out.println(x);
//		System.out.println('a' + 1);
//		try {
//			System.out.println(InetAddress.getByName("DESKTOP-JH3L89J"));
//			System.out.println(InetAddress.getByName("localhost"));
//			System.out.println(InetAddress.getByName(null));
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		int a = 1;
//		a = a++;
//		a = a + 1;
		
		int a =1;
		int b =2;
		a=a++; 
		 b=a++; 
		System.out.println(a); //输出1
		 System.out.println(b); //取消7.9行注释，注释掉6.8行，输出2
		
		
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