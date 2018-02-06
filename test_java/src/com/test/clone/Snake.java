package com.test.clone;

public class Snake implements Cloneable{
	private Snake next;
	private char c;
	public Snake(int i, char c) {
		this.c = c;
		if(--i > 0){
			next = new Snake(i, (char)(c + 1));
		}
	}
	
	void increment(){
		c++;
		if(next != null){
			next.increment();
		}
	}
	
	@Override
	public String toString() {
		String s = ":" + c;
		if(next != null){
			s += next.toString();
		}
		return s;
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {}
		if(next != null){
			next = (Snake) next.clone();
		}
		return o;
	}
	
	public static void main(String[] args) {
		Snake s = new Snake(5, 'a');
		System.out.println(s);
		
		Snake s2 = (Snake)s.clone();
		System.out.println(s2);
		
		s.increment();
		System.out.println("after s.increment() s + " + s);
		System.out.println("after s.increment() s2 + " + s2);
		
		s2.increment();
		System.out.println("after s.increment() s + " + s);
		System.out.println("after s.increment() s2 + " + s2);
	}
}
