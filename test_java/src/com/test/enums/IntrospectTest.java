package com.test.enums;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectTest {
	public static void main(String[] args) throws Exception {
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		int x = pt1.getX();
//		String propertyName = "x";
//		Object obj = 666;
//		setProperty(pt1, propertyName, obj);
//		Object defaultValue = getProperty(pt1, propertyName);
//		System.out.println(pt1.getX());
		System.out.println(getValue(pt1, "x"));
	}

	private static void setProperty(ReflectPoint pt1, String propertyName, Object obj)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass());
		Method writeMethodx = pd.getWriteMethod();
		writeMethodx.invoke(pt1, obj);
	}

	private static Object getProperty(ReflectPoint pt1, String propertyName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass());
		Method readMethodx = pd.getReadMethod();
		Object defaultValue = readMethodx.invoke(pt1);
		return defaultValue;
	}
	
	// 通过字段名，获取该字段的值
	private static Object getValue(Object obj, String propertyName) throws Exception{
		Object retVal = null;
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if(pd.getName().equals(propertyName)){
				Method readMethod = pd.getReadMethod();
				retVal = readMethod.invoke(obj);
			}
		}
		return retVal;
	}
}
