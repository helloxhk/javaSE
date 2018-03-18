package com.ssm.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor{

	private Object delegateObj;
	
	/**
	 * 生成代理对象
	 * @param delegateObj
	 * @return
	 */
	public Object bind(Object delegateObj){
		this.delegateObj = delegateObj;
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(this.delegateObj.getClass());
		return enhancer.create();
	}
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("方法执行前");
		
		Object retObj = method.invoke(this.delegateObj, args);
		
		System.out.println("方法执行后");
		
		return retObj;
	}
	
	public static void main(String[] args) {
		CglibDynamicProxy proxy = new CglibDynamicProxy();
		UserService userService = (UserService) proxy.bind(new UserService());
		userService.add();
	}
}
