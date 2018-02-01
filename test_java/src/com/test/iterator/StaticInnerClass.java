package com.test.iterator;

public class StaticInnerClass {
	static String str;
	static class A {
		
		String x = str;
	}
}

interface InterfaceX {
	
	static class XX {
		int i;
		void get(){
			
		}
		public XX() {
		}
	}
}