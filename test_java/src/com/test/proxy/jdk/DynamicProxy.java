package com.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

	// 委托对象
	private Object delegateObj;
	
	public Object bind(Object delegateObj){
		this.delegateObj = delegateObj;
		return Proxy.newProxyInstance(delegateObj.getClass().getClassLoader(),
				delegateObj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法执行前");
		Object obj = method.invoke(delegateObj, args);
		System.out.println("方法执行后");
		return obj;
	}
	
	public static void main(String[] args) {
		DynamicProxy proxy = new DynamicProxy();
		UserInterface user = (UserInterface) proxy.bind(new UserImpl());
		user.add();
		user.update();
	}
	
}
