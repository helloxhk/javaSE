package com.test.clone;

public class LocalCopy {
	
	static MyObject g(MyObject o){
		o.i++;
		return o;
	}
	
	static MyObject f(MyObject o){
		o = (MyObject) o.clone();
		o.i++;
		return o;
	}
	public static void main(String[] args) {
		MyObject a = new MyObject(11);
		MyObject b = g(a);
		if(a == b){
			System.out.println("a == b");
		} else {
			System.out.println("a != b");
		}
		System.out.println("a = " + a);
		System.out.println("a = " + b);
		
		MyObject c = new MyObject(33);
		MyObject d = f(c);
		if(c == d){
			System.out.println("c == d");
		} else {
			System.out.println("c != d");
		}
		System.out.println("a = " + c);
		System.out.println("a = " + d);
	}
}

class MyObject implements Cloneable {
	int i;
	public MyObject(int i) {
		this.i = i;
	}
	
	@Override
	protected Object clone(){
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("MyObject can`t clone");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

