package com.test.thread;

public class TraditionalThreadSync {

	public static void main(String[] args) {
		new TraditionalThreadSync().init();
	}
	
	private void init() {
		final OutPuter outPuter = new OutPuter();
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outPuter.output("zhangsan");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outPuter.output("xuhaikuan");
				}
			}
		}).start();
		
	}

	class OutPuter {
		public void output(String name){
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}

}
