package com.ssm.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MainClass implements InvocationHandler{

	public static void main(String[] args) {
		/*final Object object = new Object();
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before method");
				return method.invoke(object, args);
			}
		});
		enhancer.setSuperclass(Object.class);
		Object create = enhancer.create();
		System.out.println(create);*/
		
		
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}

}
