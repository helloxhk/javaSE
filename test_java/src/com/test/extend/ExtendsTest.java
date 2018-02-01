package com.test.extend;

/**
 * 初始化过程 
 * 1.加载class对象时，静态初始化 
 * 2.成员变量初始化，基本数据类型初始默认值，引用数据类型初始null
 * 3.构造方法初始化
 * @author xhk
 *
 */
class SuperExtends {
	private int i = 9;
	int j;

	public SuperExtends() {
		prt("i = " + i + ",j = " + j);
		j = 10;
	}

	static int x = prt("super initialize");

	static int prt(String str) {
		System.out.println(str);
		return 47;
	}
}

public class ExtendsTest extends SuperExtends {
	// int y = prt("y initialize");
	public ExtendsTest() {
		prt("y = " + y + ",j = " + j);
		j = 12;
	}

	int y = prt("xx initialize");

	static int x = prt("sub initialize");

	public static void main(String[] args) {
		prt("sub constuctor");
		new ExtendsTest();
	}
}

/*class A extends C{
	public A() {
		System.out.println("A");
	}
}

class B {
	public B() {
		System.out.println("B");
	}
}

class C {
	B b = new B();
	public static void main(String[] args) {
		C c = new C();
	}
}*/