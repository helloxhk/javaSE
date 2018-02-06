package com.test.exception;

public class StackOverFlow {
	public static void main(String[] args) {
		Excemple e = new Excemple();
		System.out.println(e);
	}
}

class Excemple {
	@Override
	public String toString() {
		/**
		 * "" 后如果跟的不是字符串，会调用该对象的toString()方法，此时会出现无限调用toString()的情况
		 * 当堆栈满的时候，就会出现 java.lang.StackOverflowError 异常
		 */
		return "无限循环 ：" + this;
	}
}
