package com.test.filter;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		return str.replace("����ҵ", "��ҵ");
	}

}
