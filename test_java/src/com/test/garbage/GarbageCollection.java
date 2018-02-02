package com.test.garbage;

/**
 * 垃圾回收：
 * 		衍生类被回收时，如果finalize()方法中没有调用父类的finalize()方法。则不会回收父类。
 * @author xhk
 *
 */
public class GarbageCollection {
	public static void main(String[] args) {
		FlagClass.flag = true;
		new Frog();
		System.out.println("bye!");
		System.runFinalizersOnExit(true);
	}
}

class FlagClass {
	public static boolean flag = false;
}

// 特征
class Characteristic {
	String s ;
	public Characteristic(String s) {
		this.s = s;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalizing Characteristic " + s);
	}
}

class Living {
	Characteristic c = new Characteristic("is alive");
	public Living() {
		System.out.println("Living");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Living finalizing");
		if(FlagClass.flag){
			super.finalize();
		}
	}
}

class Animal extends Living {
	Characteristic c = new Characteristic("has heart");
	public Animal() {
		System.out.println("Animal");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Animal finalizing");
		if(FlagClass.flag){
			super.finalize();
		}
	}
}

class Amphibian extends Animal {
	Characteristic c = new Characteristic("can live in water");
	public Amphibian() {
		System.out.println("Amphibian");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Amphibian finalizing");
		if(FlagClass.flag){
			super.finalize();
		}
	}
}

class Frog extends Amphibian {
	public Frog() {
		System.out.println("Frog");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Frog finalizing");
		if(FlagClass.flag){
			super.finalize();
		}
	}
}