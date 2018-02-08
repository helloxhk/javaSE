package com.jdk8.annotation;

import java.lang.annotation.Repeatable;

public class NewAnnotations {

}

@Repeatable(Hints.class)
@interface Hint {
	String value();
}

@interface Hints {
	Hint[] value();
}

/**
 * 老方式
 */
@Hints({@Hint("111"),@Hint("222")})
class Person {
	
}

/**
 * 新方式
 * 使用多重注解
 * 	这里java编译器会隐性的帮我们定义好@Hints注解，可以用反射来获取这些信息
 */
@Hint("111")
@Hint("222")
class People {
	
}