package com.test.keywords;

public class FinalTest {

}

class FinalA {
	final int i;
	FinalA(){
		i = 1;
	}
}

class FinalArguments {
	
	int fun1(final int i){
		// 非法。final基本数据类型不可修改值
		// i = 2;
		return i + 1;
	}
	
	void fun2(final Object obj){
		// final引用数据类型不可指向新的对象
		// obj = new Object();
	}
}