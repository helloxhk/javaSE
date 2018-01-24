package com.test.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 实例工厂
 * @author xhk
 *
 */
public class BeanFactory {
	
	private Properties props = new Properties();
	
	public BeanFactory(InputStream ips) {
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取bean实例对象
	 * @param name
	 * @return
	 */
	public Object getBean(String name){
		
		Class<?> clazz = null;
		Object object = null;
		try {
			clazz = Class.forName(props.getProperty(name));
			object = clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if(object instanceof ProxyFactoryBean){
			try{
				ProxyFactoryBean proxyBean = (ProxyFactoryBean)object;
				Advice advice = (Advice) Class.forName(props.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
				proxyBean.setAdvice(advice);
				proxyBean.setTarget(target);
				Object proxyObj = proxyBean.getProxyBean();
				return proxyObj;
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return object;
	}
}
