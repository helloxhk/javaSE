package com.test.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*//sun.misc.Launcher$AppClassLoader@4633c1aa
		System.out.println(ClassLoader.getSystemClassLoader());
		// sun.misc.Launcher$ExtClassLoader@6fefa3e7
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		// null
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		MyClassLoader loader = new MyClassLoader("C:\\Users\\xhk\\git\\javaSE\\test_java\\classloader");
		Class<?> clazz = loader.loadClass("com.test.classloader.TargetClass");
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("saySomething", String.class);
		method.invoke(obj, "hello classloader");
		System.out.println(clazz.getClassLoader());*/
		
		System.out.println(MainClass.class.getClassLoader());
		
	}
}
