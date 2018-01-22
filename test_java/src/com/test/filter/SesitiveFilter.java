package com.test.filter;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replace("被就业", "就业");
	}

}
