package com.test.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestClass<T> {
	
	public void save() throws InstantiationException, IllegalAccessException{
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType pType = (ParameterizedType)type;
			Class clazz = (Class)pType.getActualTypeArguments()[0];
			Object newInstance = clazz.newInstance();
		}
	}
}
