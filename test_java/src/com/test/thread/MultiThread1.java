package com.test.thread;

public class MultiThread1 {
	public static void main(String[] args) {
		new Thread(new IncrementRunnable(50)).start();
		new Thread(new DecrementRunnable(50)).start();
	}
}

class IncrementRunnable implements Runnable {

	private int count;
	
	public IncrementRunnable(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			inc();
		}
	}
	
	public synchronized void inc(){
		System.out.println("count ++ " + count);
		count++;
	}
}

class DecrementRunnable implements Runnable {
	
	private int count;
	
	public DecrementRunnable(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			dec();
		}
	}
	
	public synchronized void dec(){
		System.out.println("count -- " + count);
		count--;
	}
}
