package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * @author xhk
 *
 */
public class ProxyFactoryBean {

	/**
	 * 通知
	 */
	private Advice advice;
	
	/**
	 * 目标类
	 */
	private Object target;
	
	public Object getProxyBean() {
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						advice.beforeMethod(method);
						Object retValue = method.invoke(target, args);
						advice.afterMethod(method);
						
						return retValue;
					}
				});
		return proxy;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
}
