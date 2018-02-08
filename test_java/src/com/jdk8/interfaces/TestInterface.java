package com.jdk8.interfaces;

/**
 * 接口的默认实现方法
 * @author xhk
 */
public interface TestInterface {
	int one(int i);
	
	default int get(int i){
		return i;
	}
	
}

class TestClass implements TestInterface {

	@Override
	public int one(int i) {
		return this.get(5);
	}
	
}

class Tet{
	public static void main(String[] args) {
		TestInterface s = new TestClass();
		TestInterface interface1 = (x) -> s.get(x);
	}
}