package com.test.garbage;

/**
 * 垃圾回收测试
 * @author xhk
 *
 */
public class Garbage {
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		while(!Book.f){
			new Book();
			new String("To take up space.");
		}
		
		System.out.println("After all books have been created:\n"
				+ "total created = " + Book.created + "\n"
				+ "total finalized = " + Book.finalized);
		
		if(false){
			System.out.println("gc()");
			System.gc();
			System.out.println("runFinalization()");
			System.runFinalization();
		}
		
		while(true){
			System.runFinalizersOnExit(true);
		}
		
	}
}

class Book{
	static boolean gcrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalized = 0;
	
	int i;
	
	public Book() {
		i = ++created;
		if(created == 47)
			System.out.println("created 47");
	}
	
	protected void finalize() throws Throwable {
		if(!gcrun){
			gcrun = true;
			System.out.println("begin to finalize after " + created + "Books have been created.");
		}
		
		if(created == 47){
			System.out.println("Finalizing #47" + "       Setting flag to stop Book creation.");
			f = true;
		}
		
		finalized++;
		
		if(finalized >= created){
			System.out.println("All " + finalized + "finalized.");
		}
	}
}