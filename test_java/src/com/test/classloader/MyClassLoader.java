package com.test.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	// .class存放路径
	private String classPath;
	
	public MyClassLoader(String classPath) {
		this.classPath = classPath;
	}
	
	/**
	 * 加载.class文件 -> byte[]
	 * @param name
	 * @return
	 * @throws IOException 
	 */
	private byte[] loadBytes(String name) throws IOException{
		// name = name.replace(".", File.separator);
		name = name.substring(name.lastIndexOf(".") + 1);
		String filepath = new File(classPath) + "\\" + name + ".class";
		InputStream ips = new FileInputStream(filepath);
		int len = ips.available();
		byte[] data = new byte[len];
		ips.read(data);
		ips.close();
		return data;
	}
	
	/**
	 * 文件的位置并不是固定要在当前packge下面，可以位于磁盘中的任意文件夹下面，甚至是网络流都可以。
	 * 读取之后要把结果转换成一个byte[]，最后调用defineClass方法定义类，此处需要注意，
	 * defineClass的第一个参数name，这个是需要与当前包名保持一致的，比如我要加载的类是ClassLoaderTestDemo，
	 * packge是classloader，那这个name就是classloader.ClassLoaderTestDemo。
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] loadBytes = loadBytes(name);
			return defineClass(name, loadBytes, 0, loadBytes.length);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
		
	}

	
}
