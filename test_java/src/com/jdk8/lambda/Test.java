package com.jdk8.lambda;

/**
 * 自定义函数式接口应用
 * @author xhk
 */
class Test {
	static int count = 2;
	int count2 = 2;
	public static void main(String[] args) {
		
		/**
		 * 普通应用
		 */
		/*Converter<Integer, String> c = (i1) -> String.valueOf(i1);
		String str = c.convert(111);
		System.out.println(str);
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer i = converter.convert("111","222");
		System.out.println(i);*/
		
		/**
		 * 静态方法引用
		 */
		/*Converter<String, Integer> converter1 = Integer::valueOf;
		Integer i1 = converter1.convert("985");
		System.out.println(i1);*/
		/**
		 * 引用一个对象身上的方法
		 */
		/*Person p = new Person();
		Converter<Integer,String> converter2 = p::getString;
		String str2 = converter2.convert(999);
		System.out.println(str2 instanceof String); // true*/
		/**
		 * 引用构造方法
		 */
		/*PersonFactory<Person> pFactory = Person::new;
		Person person = pFactory.create("张三", 18);
		System.out.println(person);*/
		
		/**
		 * lambda作用域
		 * 	访问外层final变量
		 */
		/*final int num = 2;
		Converter<Integer, String> converter3 = (from) -> Integer.toString(from + num);
		System.out.println(converter3.convert(2)); // 4
		*/
		/**
		 * lambda作用域
		 * 	访问外层非变量
		 */
		/*int num1 = 2;
		Converter<Integer, String> converter3 = (from) -> Integer.toString(from + num1);
		System.out.println(converter3.convert(2)); // 4
		num1 = 4; // 报错。隐性将num1视为为final */
		/**
		 * lambda作用域
		 * 	访问局部变量，必须是final类型，虽然可以不被final修饰，但绝不可修改其值。
		 * 	访问实例内部的字段以及静态字段是可读和可写的。
		 */
		/*int num1 = 2;
		Converter<Integer, String> converter3 = (from) -> {
			num1 = 4; // 报错。隐性将num1视为为final 
			Integer.toString(from + num1);
		};
		System.out.println(converter3.convert(2)); // 4 */
		
		/*Converter<Integer, String> converter4 = (from) -> {
			count++;
			return Integer.toString(from + count);
		};
		System.out.println(converter4.convert(2)); //5 */
//		Test test = new Test();
//		test.test2();
		
		/**
		 * runnable接口也实现了函数式接口注解
		 */
		/*new Thread(()->{
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
			}
		}).start();*/
	}
	
	/**
	 * lambda表达式
	 * 	访问实例内部的变量和静态变量时，可以对变量进行修改。
	 */
	public void test2(){
		Converter<Integer, String> converter = (from) -> {
			count++;
			count2++;
			return Integer.toString(1 + count + count2);
		};
		System.out.println(converter.convert(1)); // 7
	}
}