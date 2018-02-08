package com.jdk8.new_interface;

import java.util.Optional;

/**
 * Optional接口
 * 	据说是为了NullPointException而生
 * @author xhk
 *
 */
public class OptionalTest {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("abc");
		System.out.println(optional.isPresent()); // true
		System.out.println(optional.get()); // abc
		System.out.println(optional.orElse("other")); // abc
		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // a
	}

}
