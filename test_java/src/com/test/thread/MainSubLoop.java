package com.test.thread;

/**
 * 经典线程面试题
 * 	子线程循环10次，主线程循环100次，以此类推，循环50次
 * @author xhk
 *
 */
public class MainSubLoop {
	
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}
			}
		}).start();
		
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}
}

class Business {
	
	// 标记
	private boolean flag = false;
	
	public synchronized void sub(int j){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 100; i++) {
			System.out.println("SUB thread " + i + "loop of " + j);
		}
		flag = true;
		// 唤醒主线程
		this.notify();
	}
	
	public synchronized void main(int j){
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println("MAIN thread " + i + "loop of " + j);
		}
		flag = false;
		// 唤醒子线程
		this.notify();
	}
	
	
}
