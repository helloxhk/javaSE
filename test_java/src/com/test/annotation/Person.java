package com.test.annotation;

public class Person {
	@MyAnnotation(required = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
