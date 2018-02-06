package com.test.collection;

import java.util.Stack;

public class Stacks {
	private static String[] months = 
			{"January","February","March","April"
			,"May","June","July","August"
			,"September","October","November","December"};
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < months.length; i++) {
			stack.push(months[i]);
		}
		System.out.println(stack);
		
		System.out.println("Month 5 = " + months[4]);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
