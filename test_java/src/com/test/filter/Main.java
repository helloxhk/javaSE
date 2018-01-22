package com.test.filter;


public class Main {
	public static void main(String[] args) {
		String msg = "ÄãºÃ,:),<script>";
		MsgProcessor mp = new MsgProcessor();
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new SesitiveFilter());
		mp.setMsg(msg);
		mp.setFilterChain(fc);
		String str = mp.process();
		System.out.println(str);
	}
}
