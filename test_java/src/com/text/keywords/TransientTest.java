package com.text.keywords;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("jack");
		user.setPassword("123456");
		
		System.out.println("before serialize");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		// 序列化到文件 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\test\\user.txt"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\test\\user.txt"));
			User u = (User) ois.readObject();
			System.out.println("after serialize");
			System.out.println(u.getUsername());
			System.out.println(u.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
