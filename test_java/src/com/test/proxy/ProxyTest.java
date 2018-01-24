package com.test.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class ProxyTest {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream ips = new FileInputStream(new File("config.properties"));
		BeanFactory beanFactory = new BeanFactory(ips);
		List list = (List) beanFactory.getBean("xxx");
		System.out.println(list.getClass().getName());
		list.add(1);
		System.out.println(list.size());
	}
}
