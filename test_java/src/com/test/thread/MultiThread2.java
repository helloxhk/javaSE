package com.test.thread;

public class MultiThread2 {
	
	private int count;
	
	public static void main(String[] args) {
		MultiThread2 multiThread2 = new MultiThread2();
		multiThread2.setCount(50);
		new Thread(multiThread2.new IncRunnbale()).start();
		new Thread(multiThread2.new DecRunnable()).start();
	}
	
	public synchronized void inc(){
		System.out.println("inc " + count);
		count++;
	}
	
	public synchronized void dec(){
		System.out.println("dec " + count);
		count--;
	}
	
	class IncRunnbale implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				inc();
			}
		}
	}
	
	class DecRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				dec();
			}
		}
	}

	private int getCount() {
		return count;
	}

	private void setCount(int count) {
		this.count = count;
	}
}
