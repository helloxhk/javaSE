package com.test.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	List<Filter> filters = new ArrayList<>();
	
	public FilterChain addFilter(Filter filter){
		filters.add(filter);
		return this;
	}
	
	public String doFilter(String str){
		for (Filter f : filters) {
			str = f.doFilter(str);
		}
		return str;
	}
}
