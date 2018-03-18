package com.ssm.cglib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 委托类 ：业务类
 * @author xhk
 * 2018年3月18日下午1:28:59
 */
@Service
public class UserService {

	public void add(){
		System.out.println("新建用户");
	}
	
	public void update(){
		System.out.println("编辑用户");
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = context.getBean(UserService.class);
		service.add();
	}
}
