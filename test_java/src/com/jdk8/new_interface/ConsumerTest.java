package com.jdk8.new_interface;

import java.util.function.Consumer;

import com.jdk8.lambda.Person;

/**
 * Consumer接口
 * 	感觉也没啥用。。
 * @author xhk
 *
 */
public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<Person> personConsumer = (p) -> System.out.println("Hello," + p.getName());
		
		personConsumer.accept(new Person("张三", 18));
	}

}
