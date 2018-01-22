package com.test.enums;

import java.lang.reflect.Field;

@SuppressWarnings("all")
public class MainClass {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ReflectPoint rp = new ReflectPoint(1,1);
		System.out.println(rp);
		changeStringValue(rp);
		System.out.println(rp);
	}

	private static void changeStringValue(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.getType() == String.class){
				field.setAccessible(true);
				String str = (String) field.get(obj);
				str = str.replace("b", "a");
				field.set(obj, str);
			}
		}
	}
}
