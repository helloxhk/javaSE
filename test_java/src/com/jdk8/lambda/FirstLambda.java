package com.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 初识lambda表达式
 * @author xhk
 */
public class FirstLambda {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("tom","jerry","jack","peter","mike");
		/**
		 *  传统字符串集合排序
		 */
		/*Collections.sort(names,new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});*/
		
		/**
		 * jdk8新特性
		 * 	lambda表达式
		 */
		// 形式 1
		/*Collections.sort(names,(String a,String b) -> {
			return a.compareTo(b);
		});*/
		// 形式 2
		/*Collections.sort(names,(String a, String b) -> a.compareTo(b));*/
		// 形式 3
		Collections.sort(names,(a,b) -> a.compareTo(b));
		for (String string : names) {
			System.out.print(string + " - ");
		}
		
	}

}
