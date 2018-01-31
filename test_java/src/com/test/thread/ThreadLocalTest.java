package com.test.thread;

import java.util.Random;

/**
 * 线程局部变量
 * @author xhk
 *
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					MyThreadLocal mtl = MyThreadLocal.getInstance();
					Random random = new Random();
					mtl.setAge(random.nextInt());
					mtl.setName("name" + random.nextInt());
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

}

class MyThreadLocal {
	
	private String name;
	private Integer age;
	
	private MyThreadLocal(){};
	
	private static ThreadLocal<MyThreadLocal> local = new ThreadLocal<>();
	
	public static MyThreadLocal getInstance(){
		MyThreadLocal mtl = local.get();
		if(mtl == null){
			mtl = new MyThreadLocal();
			local.set(mtl);
		}
		return mtl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
class A {
	public static void get(){
		MyThreadLocal mtl = MyThreadLocal.getInstance();
		System.out.println("A" + Thread.currentThread().getName() + "----" + mtl.getName());
		System.out.println("A" + Thread.currentThread().getName() + "----" + mtl.getAge());
	}
}
class B {
	public static void get(){
		MyThreadLocal mtl = MyThreadLocal.getInstance();
		System.out.println("B" + Thread.currentThread().getName() + "----" + mtl.getName());
		System.out.println("B" + Thread.currentThread().getName() + "----" + mtl.getAge());
	}
}
