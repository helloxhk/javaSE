package com.test.proxy.jdk;

public class UserImpl implements UserInterface {

	@Override
	public void add() {
		System.out.println("新建用户");
	}

	@Override
	public void update() {
		System.out.println("编辑用户");
	}

}
