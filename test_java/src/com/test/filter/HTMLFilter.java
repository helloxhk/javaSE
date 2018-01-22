package com.test.filter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String s = str.replace("<", "[")
				.replace(">", "]");
		return s;
	}

}
