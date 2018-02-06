package com.test.collection;

import java.util.Hashtable;

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable<Integer, Counter> ht = new Hashtable<>();
		for (int i = 0; i < 10000; i++) {
			Integer integer = new Integer((int)(Math.random() * 20));
			if(ht.containsKey(integer)){
				ht.get(integer).i++;
			} else {
				ht.put(integer, new Counter());
			}
		}
		System.out.println(ht);
	}
}

class Counter {
	int i = 1;
	@Override
	public String toString() {
		return Integer.toString(i);
	}
	
	@Override
	public int hashCode() {
		return i;
	}
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Counter && i == ((Counter)obj).i;
	}
}
