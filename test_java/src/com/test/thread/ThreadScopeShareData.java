package com.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {

	private static int data = 0;
	
	private static Map<Thread, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@SuppressWarnings("static-access")
				@Override
				public void run() {
					data = new Random().nextInt();
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A{
		public static void get(){
			data = map.get(Thread.currentThread());
			System.out.println("A :" + Thread.currentThread().getName() + data);
		}
	}
	
	static class B{
		public static void get(){
			data = map.get(Thread.currentThread());
			System.out.println("B :" + Thread.currentThread().getName() + data);
		}
	}
}
