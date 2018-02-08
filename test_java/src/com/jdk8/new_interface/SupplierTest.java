package com.jdk8.new_interface;

import com.jdk8.lambda.Person;

import java.util.function.Supplier;

/**
 * Supplier接口
 * 	返回一个泛型传入的类型的对象实例。
 * @author xhk
 */
public class SupplierTest {

	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		Person person = personSupplier.get();
		System.out.println(person);
	}

}
