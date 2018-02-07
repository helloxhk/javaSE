package com.test.thread;

public class SimpleThread extends Thread {
	private int counter = 5;
	private int id;
	private static int threadCount = 0;
	public SimpleThread() {
		id = ++threadCount; 
		
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println("Thread #" + id + "编号" + counter);
			if(--counter == 0)
				return;
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread().start();
		}
		System.out.println("all thread have started");
	}
}
