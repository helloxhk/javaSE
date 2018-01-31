package com.test.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {
	public static void main(String[] args) {
//		new Timer().schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("bombing!");
//				new Timer().schedule(new TimerTask() {
//					
//					@Override
//					public void run() {
//						System.out.println("bombing in!");
//					}
//				}, 2000);
//			}
//		}, 3000);
		@SuppressWarnings("unused")
		class MyTimerTask extends TimerTask {

			@Override
			public void run() {
				System.out.println("bombing!");
				new Timer().schedule(new MyTimerTask(), 2000);
			}
			
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
