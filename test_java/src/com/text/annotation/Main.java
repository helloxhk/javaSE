package com.text.annotation;

import java.lang.reflect.Field;

public class Main {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person person = new Person();
		person.setName("ABC");
		@SuppressWarnings("rawtypes")
		Class clazz = person.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
			if(annotation.required()){
				field.setAccessible(true);
				Object object = field.get(person);
				System.out.println(object);
				if(object == null){
					System.out.println(field.getName() + "is required");
				}
			}
		}
	}
}
