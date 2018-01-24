package com.test.proxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

	@Override
	public void beforeMethod(Method method) {
		System.out.println("before method :" + method.getName() + "--------------");
	}

	@Override
	public void afterMethod(Method method) {
		System.out.println("after method :" + method.getName() + "--------------");
	}

}
