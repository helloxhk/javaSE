package com.jdk8.lambda;

/**
 * 函数式接口
 * 	lambda表达式应用
 * 	每一个lambda表达式对应一个类型，通常是接口类型。
 * 	而函数式接口是指仅仅包含一个抽象方法的接口，每一个该类型的lambda表达式都会匹配到这个抽象方法。
 * 	因为默认方法不算抽象方法，所以也可以为函数式接口添加默认方法。
 * 
 * 	注意：@FunctionalInterface注解可有可无
 * @author xhk
 *
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F,T> {
	T convert(F f);
}
