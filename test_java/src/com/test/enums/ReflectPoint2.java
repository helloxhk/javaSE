package com.test.enums;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class ReflectPoint2 {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// InputStream ips = new FileInputStream("config.properties");
		// 从classPath目录下找文件
		InputStream ips1 = ReflectPoint2.class.getClassLoader().getResourceAsStream("com/test/reflect/config.properties");
		// 相对路径找文件（相对本类的路径）
		InputStream ips2 = ReflectPoint2.class.getResourceAsStream("com/test/reflect/config.properties");
		// 从classPath目录下找文件
		InputStream ips3 = ReflectPoint2.class.getResourceAsStream("/com/test/reflect/config.properties");
		
		Properties props = new Properties();
		props.load(ips1);
		String className = props.getProperty("className");
		@SuppressWarnings("unchecked")
		Collection<ReflectPoint> collection = (Collection<ReflectPoint>) Class.forName(className).newInstance();
		ReflectPoint pt1 = new ReflectPoint(1, 1);
		ReflectPoint pt2 = new ReflectPoint(2, 2);
		ReflectPoint pt3 = new ReflectPoint(3, 3);
		ReflectPoint pt4 = new ReflectPoint(1, 1);
		collection.add(pt1);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt4);
		// 修改pt3对象中参与hashCode方法的字段，使得pt3的哈希码改变，导致collection中key不对应
//		pt3.setX(1);
		collection.remove(pt3);
		System.out.println(collection.size()); // 2
	}
}
