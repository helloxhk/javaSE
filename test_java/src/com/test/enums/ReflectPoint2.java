package com.test.enums;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class ReflectPoint2 {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// InputStream ips = new FileInputStream("config.properties");
		// ��classPathĿ¼�����ļ�
		InputStream ips1 = ReflectPoint2.class.getClassLoader().getResourceAsStream("com/test/reflect/config.properties");
		// ���·�����ļ�����Ա����·����
		InputStream ips2 = ReflectPoint2.class.getResourceAsStream("com/test/reflect/config.properties");
		// ��classPathĿ¼�����ļ�
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
		// �޸�pt3�����в���hashCode�������ֶΣ�ʹ��pt3�Ĺ�ϣ��ı䣬����collection��key����Ӧ
//		pt3.setX(1);
		collection.remove(pt3);
		System.out.println(collection.size()); // 2
	}
}
