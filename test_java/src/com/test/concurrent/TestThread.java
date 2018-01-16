package com.test.concurrent;

public class TestThread implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
			}
		}
	}

	public static void main(String[] args) {
//		TestThread th1 = new TestThread();
//		Thread ta = new Thread(th1, "A");
//		Thread tb = new Thread(th1, "B");
//		ta.start();
//		tb.start();
		System.out.println(Math.E);
		System.out.println(Math.PI);
	}
}
