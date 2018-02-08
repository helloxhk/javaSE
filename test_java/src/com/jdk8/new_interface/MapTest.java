package com.jdk8.new_interface;

import java.util.HashMap;
import java.util.Map;

/**
 * Map类
 * 	不支持stream
 * 
 * @author xhk
 *
 */
public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "value " + i);
		}
		
//		map.forEach((id,val) -> System.out.println("id:" + id + " - val:" + val));
		/**
		 * 如果存在key
		 * 则执行函数
		 */
		map.computeIfPresent(3, (key,val) -> val + key);
		System.out.println(map.get(3));
		
		map.computeIfPresent(9, (key,val) -> null);
		System.out.println(map.containsKey(9));
		
		/**
		 * 如果不存在key
		 * 	则执行函数并将结果以
		 * 		key为键放以函数返回值为值
		 * 	放入集合
		 */
		map.computeIfAbsent(20, key -> "value "+ key);
		System.out.println(map.containsKey(20));
		System.out.println(map.get(20));
		
		map.computeIfAbsent(3, key -> "nonono");
		System.out.println(map.get(3));
		
		/**
		 * map中
		 * 	删除一个键值都匹配的项
		 */
		boolean b = map.remove(3, "value3");
		System.out.println(b);
		boolean b2 = map.remove(3, "value 33");
		System.out.println(b2);
		
		/**
		 * map中
		 * 	获取key对应的值，并指定默认值
		 * 	如果为null则返回指定的默认值
		 */
		String orDefault = map.getOrDefault(22, "not found");
		System.out.println(orDefault);
		
		/**
		 * map中
		 * 	元素合并 map.merge(key,val,function);
		 * 	Merge做的事情是如果键名不存在则插入，否则则对原键对应的值做合并操作并重新插入到map中。
		 */
		map.merge(30, "value 30", (val,newVal) -> val.concat(newVal));
		System.out.println(map.get(30));
		map.merge(30, map.get(0), (val,newVal) -> val.concat(newVal));
		System.out.println(map.get(30));
		
		
//		forEachMap(map);
	}
	
	/**
	 * forEach
	 */
	public static void forEachMap(Map<Integer, String> map){
		map.forEach((key,val) -> System.out.println(key + " : " + val));
	}
}
