package com.test.extend;

public class Test {
	public static void main(String[] args) {
		System.out.println(new BB().i);
	}
}

class AA {
	int i = 1;
}

class BB extends AA {
	int i = 2;
}
