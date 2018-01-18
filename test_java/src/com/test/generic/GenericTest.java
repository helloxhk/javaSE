package com.test.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型：
 * 	1.给javac编译器使用。可以限定集合中的输入类型。
 * 	编译期进行代码的检查，规避程序中的非法输入，编译后，去掉‘类型’信息，使程序的运行效率不受影响。
 * 	2.对于参数化的泛型类型，getClass()方法返回值和原始类型完全一样。
 * 	3.由于编译器生成的字节码会去掉泛型的类型信息，只要能跳过编译器，就可以往某个泛型集合中加入其它类型的数据。
 * 	如：用反射得到集合，再调用其add方法。
 * 	4.只有引用类型才能当做泛型方法的参数。
 *
 */
public class GenericTest {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/**
		 * 2.
		 */
//		List<String> list = new ArrayList<String>();
		// java.util.ArrayList
//		System.out.println(list.getClass().getName());
//		List<Object> list2 = list; // 报错
//		System.out.println(list);
//		System.out.println(list2);
		
		/**
		 * 3.
		 */
		//  java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		List<String> stringList = new ArrayList<>();
		stringList.getClass().getMethod("add", Object.class).invoke(stringList, 1);
		System.out.println(stringList.get(0));
		
		/**
		 * 4.
		 */
		// 报错
//		int[] array = new int[]{1,2,3,};
//		swap(array, 1, 2);
	}
	
	/**
	 * 泛型中的通配符
	 * @param collection
	 */
	public static void printCollection(Collection<?> collection){
		for (Object obj : collection) {
			System.out.println(obj);
		}
		
		// 向上限定符  - object或object的子类
		List<? extends Object> list = new ArrayList<>();
		
		// 向下限定符  - object或object的父类
		List<? super Object> list2 = new ArrayList<>();
	}
	
	/**
	 * 遍历参数化的map集合
	 */
	public static void iteratorMap(){
		Map<String, Integer> map = new HashMap<>();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	
	/**
	 * 自定义泛型方法
	 */
	public static <T> T getValue(T t){
		return null;
	}
	public static <T> void getValue(T t,String str){
		//return null;
	}
	
	/**
	 * 交换数组中元素位置
	 * @param array
	 * @param i
	 * @param j
	 */
	public static <T> void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
