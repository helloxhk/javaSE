package com.jdk8.new_interface;

import java.util.function.Function;

/**
 * Function
 * 	函数接口
 * 	有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
 * @author xhk
 *
 */
public class FunctionTest {
	public static void main(String[] args) {
		Function<String, Integer> function = Integer::valueOf;
		//Integer apply = function.apply("123");
		//System.out.println(apply); // 123
		Function<String, String> function1 = function.andThen(String::valueOf);
		System.out.println(function1.apply("123").getClass().getName());
	}
}
