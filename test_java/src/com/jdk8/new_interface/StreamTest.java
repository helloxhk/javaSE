package com.jdk8.new_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Stream接口
 * 	Stream 操作分为中间操作或者最终操作两种，
 * 	最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，
 * 	这样你就可以将多个操作依次串起来。Stream 的创建需要指定一个数据源，
 * 	比如 java.util.Collection的子类，List或者Set， Map不支持。
 * 	Stream的操作可以串行执行或者并行执行。
 * @author xhk
 */
public class StreamTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ddd2");
		list.add("aaa2");
		list.add("bbb1");
		list.add("aaa1");
		list.add("bbb3");
		list.add("ccc");
		list.add("bbb2");
		list.add("ddd1");
//		testCount(list);
//		testReduce(list);
		
		List<String> list2 = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			list2.add(UUID.randomUUID().toString());
		}
		/**
		 * parallelStream
		 * 	并行stream
		 * 	
		 */
		sortedTime(list2);
		parallelSortedTime(list2);
	}

	/**
	 * 普通排序耗时
	 */
	public static void sortedTime(List<String> list){
		long time1 = System.nanoTime();
		long count = list.stream().sorted().count();
		System.out.println("集合大小：" + count);
		long time2 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(time2 - time1);
		System.out.println(millis);
	}
	
	/**
	 * 并行排序耗时
	 */
	public static void parallelSortedTime(List<String> list){
		long time1 = System.nanoTime();
		long count = list.parallelStream().sorted().count();
		System.out.println("集合大小：" + count);
		long time2 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(time2 - time1);
		System.out.println(millis);
	}
	
	/**
	 * reduce规约
	 * 	-- 目测可以当作拼接集合中的数据来用
	 * 	这是一个最终操作，允许通过指定函数来将stream中的多个元素规约为一个元素。
	 * 	规约后的结果是返回一个Optional接口表示。
	 */
	public static void testReduce(List<String> list){
		Optional<String> reduce = list.stream().sorted().reduce((s1,s2) -> s1 + "--" + s2);
		reduce.ifPresent(System.out::println);
	}
	
	/**
	 * count计数
	 * 	最终操作，返回stream中的元素个数
	 * 	返回值类型long
	 */
	public static void testCount(List<String> list){
		long count = list.stream().filter((s) -> s.startsWith("a")).count();
		System.out.println(count);
	}
	
	/**
	 * match匹配
	 * 	stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。
	 * 	所有的匹配操作都是最终操作，并返回一个boolean类型的值。
	 * 		anyMatch(..); 有一个匹配就返回true
	 * 		allMatch(..); 全部匹配则返回true
	 * 		noneMath(..); 全不匹配则返回true
	 */
	public static void testMatch(List<String> list){
		System.out.println("------match匹配--------------------------------------------");
		boolean b1 = list.stream().anyMatch((s) -> s.startsWith("a")); // true
		boolean b2 = list.stream().allMatch((s) -> s.startsWith("a")); // false
		boolean b3 = list.stream().noneMatch((s) -> s.startsWith("0")); // true
		System.out.println(b1 + "\r\n" + b2 + "\r\n" + b3);
	}
	
	/**
	 * Map映射
	 * 	中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象
	 * 	也可以通过map来讲对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
	 */
	public static void testMap(List<String> list){
		System.out.println("------map映射--------------------------------------------");
		list.stream().map(String::toUpperCase).sorted().forEach(System.out::print);
		System.out.println("原始数据");
		System.out.println(list); // [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
		Stream<Object> map = list.stream().map((s) -> (Object)s);
	}
	
	/**
	 * filter过滤
	 * 	过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）
	 * forEach遍历
	 * 	forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
	 */
	public static void testFilter(List<String> list){
		System.out.println("------filter--------------------------------------------");
		
		list.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
	}
	
	/**
	 * sort排序
	 * 	排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
	 * 
	 * 	需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的
	 */
	public static void testSorted(List<String> list){
		System.out.println("------sort--------------------------------------------");
		list.stream().filter((s) -> s.length() > 3).sorted().forEach(System.out::println);
		System.out.println("原始数据");
		System.out.println(list); // [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
	}
}
