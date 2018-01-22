package com.test.filter;

public class MsgProcessor {

	String msg;
	
	FilterChain filterChain;
	
	public FilterChain getFilterChain() {
		return filterChain;
	}
	
	public void setFilterChain(FilterChain filterChain) {
		this.filterChain = filterChain;
	}

	public String process(){
		return filterChain.doFilter(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	};
	
}
