package com.jdk8.lambda;

@FunctionalInterface
public interface PersonFactory<P extends Person> {
	P create(String name, int age);
}
