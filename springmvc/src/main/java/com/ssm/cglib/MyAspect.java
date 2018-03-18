package com.ssm.cglib;

/**
 * 切面
 * @author xhk
 * 2018年3月18日下午1:38:37
 */
public class MyAspect {
	
	/**
	 * 通知
	 */
	public void before(){
		System.out.println("方法执行前");
	}
	
}
