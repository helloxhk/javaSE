package com.test.algorithm;

public class LoopJudgeEmpty4Array {
	
	Object[] objs = new Object[10];
	
	boolean looped = false;
	
	int next = 0;
	
	Object getNext(){
		// 起始索引
		int start = next;
		
		do {
			/**
			 * 判断数组是否循环一轮
			 */
			next = (next + 1) % objs.length;
			
			if(start == next)
				looped = true;
			
			/**
			 * 如果循环一轮后 循环到当前位置的下一位，则断定数组为空
			 */
			if((next == (start + 1) % objs.length) && looped)
				return null;
			
		} while (objs[next] == null);
		
		return objs[next];
	}
	
	
}
